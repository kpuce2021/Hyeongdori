package org.techtown.graduation

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Base64
import android.util.Log
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import com.android.volley.AuthFailureError
import com.android.volley.DefaultRetryPolicy
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import org.json.JSONObject
import org.techtown.graduation.DBKey.Companion.USERS
import org.techtown.graduation.DBKey.Companion.PictureContent
import org.techtown.graduation.DBKey.Companion.PictureDate
import org.techtown.graduation.DBKey.Companion.PictureId
import org.techtown.graduation.DBKey.Companion.PictureUrl
import org.techtown.graduation.databinding.ActivityDetectImgBinding
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileNotFoundException
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.HashMap

@RequiresApi(Build.VERSION_CODES.M)
class DetectPicture2Activity : AppCompatActivity() {
    private lateinit var binding: ActivityDetectImgBinding

    private var auth : FirebaseAuth = FirebaseAuth.getInstance()
    private lateinit var userDB : DatabaseReference

    lateinit var currentPhotoPath: String
    lateinit var selected_bitmap:Bitmap
    var takedPhotoURI: Uri? = null
    var selectedPhotoURI:Uri? = null
    var requestQueue: RequestQueue? = null
    var responsePhotoURI:String? = null


    companion object {
        val REQUEST_SELECT_IN_GALLERY = 0
        val REQUEST_TAKE_PHOTO = 1
        val REQUEST_PERMISSIONS = 100
        var myUrl = "http://3.37.42.228:8080/main-1.0.0-BUILD-SNAPSHOT/receive/receiveImage"
        val requiredPermissions = arrayOf(
            Manifest.permission.CAMERA,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.INTERNET
        )
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDetectImgBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        userDB = Firebase.database.reference
        initTakePictureButton()
        initSelectImgButton()
//        initUploadImgButton()
        initUploadImgButtonTest()
        initSaveImgButton()
        checkPermissions()
    }


    private fun initTakePictureButton(){
        binding.takePictureButton.setOnClickListener {
            dispatchTakePictureIntent()
        }
    }

    private fun dispatchTakePictureIntent() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            takePictureIntent.resolveActivity(packageManager)?.also {
                // Create the File where the photo should go
                val photoFile: File? = try {
                    createImageFile()
                } catch (ex: IOException) {
                    null
                }
                // Continue only if the File was successfully created
                photoFile?.also {
                    takedPhotoURI = FileProvider.getUriForFile(this, "org.techtown.graduation.fileprovider", it)
                    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, takedPhotoURI)
                    startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO)
                }
            }
        }
    }

    private fun createImageFile(): File {
        val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val storageDir: File? = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File.createTempFile("JPEG_${timeStamp}_", ".jpg", storageDir)
            .apply { currentPhotoPath = absolutePath }
    }

    private fun initUploadImgButtonTest(){
        binding.uploadImgButton.setOnClickListener {
            Glide.with(this).load("http://blog.jinbo.net/attach/615/200937431.jpg").into(binding.imgSelected)
            responsePhotoURI = "http://blog.jinbo.net/attach/615/200937431.jpg"
            binding.uploadImgButton.visibility = GONE
            binding.saveImgButton.visibility = VISIBLE
        }
    }

    private fun initUploadImgButton(){
        if (requestQueue == null) requestQueue = Volley.newRequestQueue(applicationContext)
        binding.uploadImgButton.setOnClickListener {
            val baos = ByteArrayOutputStream()
            selected_bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos)
            val imageBytes = baos.toByteArray()
            val imageString = Base64.encodeToString(imageBytes, Base64.DEFAULT)

            //sending image to server
            val request: StringRequest = object : StringRequest(Method.POST, myUrl, Response.Listener { s ->
                val jsonObject = JSONObject(s)
                Glide.with(this).load(jsonObject.get("url").toString()).into(binding.imgSelected)
                responsePhotoURI = jsonObject.get("url").toString()
                binding.uploadImgButton.visibility = GONE
                binding.describeImgText.setText(jsonObject.get("result").toString())
                binding.saveImgButton.visibility = VISIBLE

            }, Response.ErrorListener { volleyError ->
                Toast.makeText(this@DetectPicture2Activity, "Some error occurred -> $volleyError", Toast.LENGTH_LONG).show()

            }) {
                //adding parameters to send
                @Throws(AuthFailureError::class)
                override fun getParams(): Map<String, String> {
                    val parameters: MutableMap<String, String> = HashMap()
                    parameters["image"] = imageString
                    return parameters
                }
            }


            request.retryPolicy = DefaultRetryPolicy(
                5000,
                10,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
            )

            val rQueue = Volley.newRequestQueue(this@DetectPicture2Activity)
            rQueue.add(request)
        }

    }

    private fun initSelectImgButton(){
        binding.selectImgButton.setOnClickListener {
            val intent = Intent()
            intent.type = "image/*"
            intent.action = Intent.ACTION_GET_CONTENT

            startActivityForResult(Intent.createChooser(intent, "Load Picture"), REQUEST_SELECT_IN_GALLERY)
        }
    }

    private fun initSaveImgButton(){
        binding.saveImgButton.setOnClickListener {
            if (responsePhotoURI != null){
            savePictureToDB(responsePhotoURI!!)
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.P)
    @Override
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_TAKE_PHOTO){
            if(resultCode == Activity.RESULT_OK) {
                if (takedPhotoURI != null) {
                    Glide.with(this).load(takedPhotoURI).into(binding.imgSelected)
                    selected_bitmap = ImageDecoder.decodeBitmap(
                        ImageDecoder.createSource(
                            contentResolver,
                            takedPhotoURI!!
                        )
                    )
                }
            }
        }

        if(requestCode == REQUEST_SELECT_IN_GALLERY){
            if(resultCode == Activity.RESULT_OK){
                selectedPhotoURI = data?.data
                if(selectedPhotoURI != null){
                    Glide.with(this).load(selectedPhotoURI).into(binding.imgSelected)
                    selected_bitmap = ImageDecoder.decodeBitmap(ImageDecoder.createSource(contentResolver,selectedPhotoURI!!))
                }
            } else{ }
        }


    }

    private fun savePictureToDB(url:String){
        val currentUserDB =userDB.child(getCurrentUserID()).child("Picture").push()
        val picture = mutableMapOf<String, Any>()


        picture[PictureId] = currentUserDB.key.toString()
        picture[PictureDate] = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        picture[PictureContent] = binding.describeImgText.text.toString()
        picture[PictureUrl] = url


        currentUserDB.updateChildren(picture)
        finish()
    }

    private fun checkPermissions() {
        //거절되었거나 아직 수락하지 않은 권한(퍼미션)을 저장할 문자열 배열 리스트
        var rejectedPermissionList = ArrayList<String>()

        //필요한 퍼미션들을 하나씩 끄집어내서 현재 권한을 받았는지 체크
        for(permission in requiredPermissions){
            if(ContextCompat.checkSelfPermission(this, permission) != PackageManager.PERMISSION_GRANTED) {
                //만약 권한이 없다면 rejectedPermissionList에 추가
                rejectedPermissionList.add(permission)
            }
        }
        //거절된 퍼미션이 있다면...
        if(rejectedPermissionList.isNotEmpty()){
            //권한 요청!
            val array = arrayOfNulls<String>(rejectedPermissionList.size)
            ActivityCompat.requestPermissions(this, rejectedPermissionList.toArray(array), REQUEST_PERMISSIONS)
        }
    }

    override fun onRequestPermissionsResult( requestCode: Int, permissions: Array<out String>, grantResults: IntArray ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        when(requestCode){
            REQUEST_PERMISSIONS-> {
                if(grantResults.isNotEmpty()) {
                    for ((i, permission) in permissions.withIndex()) {
                        if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                            //권한 획득 실패
                            Log.i("TAG", "The user has denied to $permission")
                            Log.i("TAG", "I can't work for you anymore then. ByeBye!")


                        }
                    }
                }
            }
        }
    }

    private fun getCurrentUserID():String{
        if (auth.currentUser == null){
            // 로그인이 안되어 있음
            finish()
        }
        return auth.currentUser?.uid.orEmpty()
    }
}
