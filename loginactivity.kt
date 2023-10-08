package com.example.quizappdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class loginactivity : AppCompatActivity() {
    lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loginactivity)
        supportActionBar?.hide()
        firebaseAuth= FirebaseAuth.getInstance()
        var loginbutton=findViewById<Button>(R.id.loginbut)
        loginbutton.setOnClickListener{
            loginuser()
        }
        var signiptext=findViewById<TextView>(R.id.signuptext)
        signiptext.setOnClickListener {
            var myintent= Intent(this,signupactivity::class.java)
            startActivity(myintent)
            finish()
        }
    }


    private fun loginuser(){
        var email=findViewById<EditText>(R.id.email)
        var emailid=email.text.toString()
        var paswword=findViewById<EditText>(R.id.password).text.toString()

        if(emailid.isBlank()||paswword.isBlank()){
            Toast.makeText(this,"Fields can't be blank",Toast.LENGTH_SHORT).show()
            return
        }

        firebaseAuth.signInWithEmailAndPassword(emailid,paswword)
            .addOnCompleteListener(this){
                if(it.isSuccessful){
                    Toast.makeText(this,"Signed in!!",Toast.LENGTH_SHORT).show()
                    var myintent= Intent(this,Quizactivity::class.java)
                    startActivity(myintent)
                    finish()

                }else{
                    Toast.makeText(this,"Error Signing in",Toast.LENGTH_SHORT).show()
                }
            }


    }
}