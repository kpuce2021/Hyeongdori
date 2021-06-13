package org.techtown.graduation

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import org.techtown.graduation.databinding.ActivityLoginBinding
import org.techtown.graduation.DBKey.Companion.USERS

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private var auth:FirebaseAuth = Firebase.auth

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initEmailAndPasswordEditText()
        initLoginButton()
        initJoinButton()
    }

    private fun initEmailAndPasswordEditText(){
        binding.emailEdit.addTextChangedListener(object:TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(p0: Editable?) {
                if (android.util.Patterns.EMAIL_ADDRESS.matcher(getInputEmail()).matches()){
                    binding.emailEdit.setBackgroundResource(R.drawable.round_image)
                    binding.loginButton.isEnabled = true
                    binding.joinButton.isEnabled = true
                }
                else{
                    binding.emailEdit.setBackgroundResource(R.drawable.round_image_red)
                    binding.loginButton.isEnabled = false
                    binding.joinButton.isEnabled = false
                }
            }
        })

        binding.passwordEdit.addTextChangedListener(object:TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun afterTextChanged(p0: Editable?) {
                if (getInputPassword().length >= 6){
                    binding.passwordEdit.setBackgroundResource(R.drawable.round_image)
                    binding.loginButton.isEnabled = true
                    binding.joinButton.isEnabled = true
                }
                else{
                    binding.passwordEdit.setBackgroundResource(R.drawable.round_image_red)
                    binding.loginButton.isEnabled = false
                    binding.joinButton.isEnabled = false
                }
            }
        })
    }

    private fun initLoginButton(){
        binding.loginButton.setOnClickListener {
            auth.signInWithEmailAndPassword(getInputEmail(), getInputPassword())
                .addOnCompleteListener(this) {
                    if(it.isSuccessful){
                        handleSuccessLogin()
                    }
                    else{
                        Toast.makeText(applicationContext, it.exception.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }

    private fun initJoinButton(){
        binding.joinButton.setOnClickListener {
            auth.createUserWithEmailAndPassword(getInputEmail(), getInputPassword())
                .addOnCompleteListener(this) {
                    if (it.isSuccessful){
                        Toast.makeText(this, "SignUp Success", Toast.LENGTH_SHORT).show()
                    }
                    else{
                        Toast.makeText(this, "SignUp Fail", Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }

    private fun handleSuccessLogin(){
        if(auth.currentUser == null){
            return
        }

        val userId = auth.currentUser?.uid.orEmpty()
        Log.d("loginToken",userId)
        Firebase.database.reference.child(USERS).child(userId)
        finish()
    }

    private fun getInputEmail():String{
        return binding.emailEdit.text.toString()
    }

    private fun getInputPassword():String{
        return binding.passwordEdit.text.toString()
    }
}