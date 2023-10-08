package com.example.quizappdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.viewbinding.ViewBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class Quizactivity : AppCompatActivity() {



    private lateinit var list: ArrayList<Question>
    private var count=0
    private var score=0
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        supportActionBar?.hide()

        setContentView(R.layout.activity_quizactivity)

        list=ArrayList<Question>()

        Firebase.firestore.collection("quizzes")
            .get().addOnSuccessListener {
            doct->
                list.clear()
                for(i in doct.documents){
                    var questionmodel=i.toObject(Question::class.java)
                    list.add(questionmodel!!)
                }

                var myques=findViewById<TextView>(R.id.myques)
                var op1=findViewById<Button>(R.id.op1)
                var op2=findViewById<Button>(R.id.op2)
                var op3=findViewById<Button>(R.id.op3)
                var op4=findViewById<Button>(R.id.op4)

                myques.setText(list.get(0).questionn)
                op1.setText(list.get(0).option1)
                op2.setText(list.get(0).option2)
                op3.setText(list.get(0).option3)
                op4.setText(list.get(0).option4)


            }

        //list.add(Question("What is the Capital of WB","Kolkata","Delhi","Delhi","CHennai","Kolkata"))
        //list.add(Question("What is the Capital of India","Delhi","Kolkata","Delhi","CHennai","Kolkata"))
        //list.add(Question("What is the Capital of Maharashtra","CHennai","Delhi","Delhi","Kolkata","Kolkata"))
        //list.add(Question("What is the Capital of IDK","Kolkata","Delhi","Delhi","CHennai","Kolkata"))
        //list.add(Question("What is the Capital of IDK2","Kolkata","Delhi","Delhi","CHennai","Kolkata"))

        var myques=findViewById<TextView>(R.id.myques)
        var op1=findViewById<Button>(R.id.op1)
        var op2=findViewById<Button>(R.id.op2)
        var op3=findViewById<Button>(R.id.op3)
        var op4=findViewById<Button>(R.id.op4)



        op1.setOnClickListener {

            nextdata(op1.text.toString())
        }
        op2.setOnClickListener {

            nextdata(op2.text.toString())
        }
        op3.setOnClickListener {

            nextdata(op3.text.toString())
        }
        op4.setOnClickListener {
            nextdata(op4.text.toString())

        }




    }
    fun nextdata(i:String){
        var myques=findViewById<TextView>(R.id.myques)
        var op1=findViewById<Button>(R.id.op1)
        var op2=findViewById<Button>(R.id.op2)
        var op3=findViewById<Button>(R.id.op3)
        var op4=findViewById<Button>(R.id.op4)

        if(count<list.size){
            if(list.get(count).ans.equals(i)){
                score++
            }
        }

        count++

        if(count>=list.size){

            var myintent=Intent(this@Quizactivity,Scoreactivity::class.java)
            myintent.putExtra("points",score)
            startActivity(myintent)
            finish()

        }else {
            myques.setText(list.get(count).questionn)
            op1.setText(list.get(count).option1)
            op2.setText(list.get(count).option2)
            op3.setText(list.get(count).option3)
            op4.setText(list.get(count).option4)
        }
    }


}