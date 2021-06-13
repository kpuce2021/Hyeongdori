package org.techtown.graduation

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Base64
import android.util.Log
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
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
import org.json.JSONObject
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileNotFoundException
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

@RequiresApi(Build.VERSION_CODES.M)
class DetectPictureActivity : AppCompatActivity() {
    private val take_picture_button:Button by lazy {   findViewById<Button>(R.id.take_picture_button)  }

    private val select_img_button:Button by lazy {  findViewById<Button>(R.id.select_img_button)  }

    private val upload_img_button:Button by lazy {  findViewById<Button>(R.id.upload_img_button)  }

    private val imageView:ImageView by lazy {  findViewById<ImageView>(R.id.img_selected) }

    private val describeText:TextView by lazy { findViewById<TextView>(R.id.describeImgText) }

    lateinit var photoURI: Uri
    lateinit var currentPhotoPath: String
    lateinit var selected_bitmap:Bitmap
    var requestQueue: RequestQueue? = null
    var myUrl = "http://3.37.42.228:8080/main-1.0.0-BUILD-SNAPSHOT/receive/receiveImage"
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    companion object {
        val Gallery = 0
        val REQUEST_TAKE_PHOTO = 1
        val REQUEST_PERMISSIONS = 100

        val requiredPermissions = arrayOf(
            Manifest.permission.CAMERA,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.INTERNET
        )
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_Graduation)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initTakePictureButton()
        initSelectImgButton()
        initUploadImgButton()
        checkPermissions()
    }


    private fun initTakePictureButton(){
        take_picture_button.setOnClickListener {
            dispatchTakePictureIntent()
        }
    }

    private fun dispatchTakePictureIntent() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            // Ensure that there's a camera activity to handle the intent
            takePictureIntent.resolveActivity(packageManager)?.also {
                // Create the File where the photo should go
                val photoFile: File? = try {
                    createImageFile()
                } catch (ex: IOException) {
                    null
                }
                // Continue only if the File was successfully created
                photoFile?.also {
                    photoURI = FileProvider.getUriForFile(
                        this,
                        "org.techtown.graduation.fileprovider",
                        it
                    )
                    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
                    startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO)
                }
            }
        }
    }

    private fun createImageFile(): File {
        // Create an image file name
        val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val storageDir: File? = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File.createTempFile(
            "JPEG_${timeStamp}_", /* prefix */
            ".jpg", /* suffix */
            storageDir /* directory */
        ).apply {
            // Save a file: path for use with ACTION_VIEW intents
            currentPhotoPath = absolutePath
        }
    }

    private fun initUploadImgButton(){
        if (requestQueue == null) requestQueue = Volley.newRequestQueue(applicationContext)
        upload_img_button.setOnClickListener {
            val baos = ByteArrayOutputStream()
            selected_bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos)
            val imageBytes = baos.toByteArray()
            val imageString = Base64.encodeToString(imageBytes, Base64.DEFAULT)


            //sending image to server
            val request: StringRequest = object : StringRequest(Method.POST, myUrl, Response.Listener { s ->
                Log.d("response", s.toString())

//                try{
                val jsonObject = JSONObject(s)
                Log.d("response", jsonObject.get("url").toString())
                Glide.with(this).load(jsonObject.get("url").toString()).into(imageView)

                upload_img_button.visibility = GONE
                describeText.text = jsonObject.get("result").toString()
                describeText.visibility = VISIBLE

//                } catch (ex: java.lang.Exception){
//                    imageView.setImageBitmap(null)
//                }
            }, Response.ErrorListener { volleyError ->
                Toast.makeText(this@DetectPictureActivity, "Some error occurred -> $volleyError", Toast.LENGTH_LONG).show()

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

            val rQueue = Volley.newRequestQueue(this@DetectPictureActivity)
            rQueue.add(request)
        }


    }

    private fun initSelectImgButton(){
        select_img_button.setOnClickListener {
            val intent = Intent()
            intent.type = "image/*"
            intent.action = Intent.ACTION_GET_CONTENT

            startActivityForResult(Intent.createChooser(intent, "Load Picture"), Gallery)
        }
    }

    @Override
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_TAKE_PHOTO){
            try {
                Glide.with(this).load(photoURI).into(imageView)
            } catch (e: FileNotFoundException) {
                e.printStackTrace()
            }
        }

        if(requestCode == Gallery){
            if(resultCode == Activity.RESULT_OK){
                var dataUri = data?.data
                try{
                    selected_bitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, dataUri)
                    imageView.setImageBitmap(selected_bitmap)
                } catch (e:Exception){  }
            } else{ }
        }


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
}
