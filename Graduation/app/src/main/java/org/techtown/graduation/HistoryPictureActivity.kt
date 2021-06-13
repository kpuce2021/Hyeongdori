package org.techtown.graduation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class HistoryPictureActivity : AppCompatActivity() {
    private var auth : FirebaseAuth = FirebaseAuth.getInstance()
    private lateinit var userDB : DatabaseReference

    private val adapter = PictureItemAdapter()
    private val pictureItem = mutableListOf<PictureItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history_picture)

        userDB = Firebase.database.reference.child("Users")

        val currentUserDB = userDB.child(getCurrentUserID())
        currentUserDB.addListenerForSingleValueEvent(object:ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {

            }

            override fun onCancelled(error: DatabaseError) {
            }

        })

    }

    private fun getCurrentUserID():String{
        if (auth.currentUser == null){
            // 로그인이 안되어 있음
            finish()
        }
        return auth.currentUser?.uid.orEmpty()
    }
}