package com.example.quizappdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class signupactivity : AppCompatActivity() {

    lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signupactivity)
        supportActionBar?.hide()
        firebaseAuth = FirebaseAuth.getInstance()

        var signbutton=findViewById<Button>(R.id.signupbut)
        signbutton.setOnClickListener{
            signupuser()
        }
        var logintext=findViewById<TextView>(R.id.login)
        logintext.setOnClickListener {
            var myintent= Intent(this,loginactivity::class.java)
            startActivity(myintent)
            finish()
        }
    }

    private fun signupuser() {
        var email = findViewById<EditText>(R.id.eid)
        var emailid = email.text.toString()
        var cpp = findViewById<EditText>(R.id.cpp)
        var confirmpassword = cpp.text.toString()
        var typp = findViewById<EditText>(R.id.typp)
        var typedpassword = typp.text.toString()

        if(emailid.isBlank()||confirmpassword.isBlank()||typedpassword.isBlank()){
            Toast.makeText(this, "Fields can't be blank", Toast.LENGTH_SHORT).show()
            return
        }
        if(typedpassword!=confirmpassword){
            Toast.makeText(this, "Type password correctly", Toast.LENGTH_SHORT).show()
            return
        }
        if(firebaseAuth.currentUser!=null){
            Toast.makeText(this, "Email id is already taken", Toast.LENGTH_SHORT).show()
            return
        }

        firebaseAuth.createUserWithEmailAndPassword(emailid, typedpassword)
            .addOnCompleteListener(this) {
                if (it.isSuccessful) {
                    Toast.makeText(this, "User created succeesfully", Toast.LENGTH_SHORT).show()
                    var myintent= Intent(this,Quizactivity::class.java)
                    startActivity(myintent)
                    finish()

                } else {
                    Toast.makeText(this, "Error Signing Up", Toast.LENGTH_SHORT).show()
                }

            }
    }

}