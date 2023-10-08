package com.example.quizappdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Scoreactivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scoreactivity)
        supportActionBar?.hide()
        var scoretext=findViewById<TextView>(R.id.scoretext)
        scoretext.setText("Your score is ${intent.getIntExtra("points",0)} ")

    }
}