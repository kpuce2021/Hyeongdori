package org.techtown.graduation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import org.techtown.graduation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val auth:FirebaseAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initDetectPictureView()
        initHistoryPictureView()
    }

    override fun onStart() {
        super.onStart()

        if (auth.currentUser == null){
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }

    private fun initDetectPictureView(){
        binding.detectPictureView.setOnClickListener {
            startActivity(Intent(this, DetectPicture2Activity::class.java))
        }
    }

    private fun initHistoryPictureView(){
        binding.historyPictureView.setOnClickListener {
            startActivity(Intent(this, HistoryPictureActivity::class.java))
        }
    }
}
