package com.example.quizappdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth

class introactivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_introactivity)
        supportActionBar?.hide()
        var auth=FirebaseAuth.getInstance()
        if(auth.currentUser!=null){
            redirect("MAIN")
        }
        var startedbutton=findViewById<Button>(R.id.startedbut)
        startedbutton.setOnClickListener{
            redirect("LOGIN")
        }
    }

    private fun redirect(name:String){
        var intent=when(name){
            "LOGIN"->Intent(this,loginactivity::class.java)
            "MAIN"-> Intent(this,starter::class.java)
            else->throw Exception("No path")
        }
        startActivity(intent)
        finish()
    }
}