package org.techtown.graduation

import android.Manifest
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import org.techtown.graduation.DBKey.Companion.USERS
import org.techtown.graduation.DBKey.Companion.PictureUrl
import org.techtown.graduation.DBKey.Companion.PictureId
import org.techtown.graduation.DBKey.Companion.PictureDate
import org.techtown.graduation.DBKey.Companion.PictureContent
import java.util.HashMap


class HistoryPictureActivity : AppCompatActivity() {

    private var auth : FirebaseAuth = FirebaseAuth.getInstance()
    private lateinit var userDB : DatabaseReference

    private val adapter = PictureItemAdapter()
    private val pictureItem = mutableListOf<PictureItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history_picture)

        userDB = Firebase.database.reference.child(getCurrentUserID())

        initHistoryRecyclerView()
        getPictureByUser()

//        val currentUserDB = userDB.child(getCurrentUserID())



    }

    private fun initHistoryRecyclerView(){
        val recyclerView = findViewById<RecyclerView>(R.id.historyPictureRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter= adapter
    }

    private fun getPictures(){
        val picturesDB = userDB.child("Picture")

        picturesDB.addChildEventListener(object:ChildEventListener{
            override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
                getPictureByUser()
            }

            override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) { }
            override fun onChildRemoved(snapshot: DataSnapshot) { }
            override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) { }
            override fun onCancelled(error: DatabaseError) { }
        })
    }

    private fun getPictureByUser(){
        val currentUserDB = userDB.child("Picture")
        currentUserDB.addListenerForSingleValueEvent(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                val hashValue = snapshot.value as HashMap<*, *>
                val keys = hashValue.keys

                for (i in keys){
                    val iHash = hashValue.get(i) as HashMap<*, *>
                    pictureItem.add(
                        PictureItem(
                            iHash.get(PictureId).toString(),
                            iHash.get(PictureUrl).toString(),
                            iHash.get(PictureDate).toString(),
                            iHash.get(PictureContent).toString())
                    )
                }
                adapter.submitList(pictureItem)
                Log.d("hashValue", hashValue.toString())
            }
            override fun onCancelled(error: DatabaseError) {}
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