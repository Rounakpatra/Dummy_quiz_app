package com.example.quizappdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class starter : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_starter)

        var starting=findViewById<Button>(R.id.quizstart)
        starting.setOnClickListener {
            var myinent=Intent(this,Quizactivity::class.java)
            startActivity(myinent)
        }
    }
}