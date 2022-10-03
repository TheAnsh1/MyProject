package com.example.myproject

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase

class SeeDetails:AppCompatActivity() {

    private lateinit var Name: TextView
    private lateinit var Phoneno: TextView
    lateinit var Email_id: TextView
    private lateinit var Document_Id:TextView
    private lateinit var Need: EditText
    private lateinit var Address: TextView
    private lateinit var Gender:TextView
    private lateinit var get: Button
    private lateinit var Back: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.seedetails_xml)
        Name =findViewById(R.id.nam)
        get =findViewById(R.id.get)
        Phoneno =findViewById(R.id.phon)
        Need =findViewById(R.id.Ned)
        Email_id =findViewById(R.id.Em)
        Document_Id =findViewById(R.id.dept)
        Address =findViewById(R.id.address)
        Gender =findViewById(R.id.gender)
        Back =findViewById(R.id.back)
        get.setOnClickListener {
           if(Need.text.toString().isEmpty()){
               Toast.makeText(this,"please Enter the Department id",Toast.LENGTH_LONG).show()
           }
            else {
           got(Need.text.toString())
            }
           }
        Back.setOnClickListener {
            val intent =Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        }

    private fun got(toString: String) {
        val raf = FirebaseDatabase.getInstance().getReference("user")
        raf.child(toString).get().addOnSuccessListener {
            if (it.exists()) {
                Name.text= it.child("name").value.toString()
               Email_id.text= it.child("email").value.toString()
                Phoneno.text= it.child("phoneno").value.toString()
              Document_Id.text= it.child("department").value.toString()
               Address.text = it.child("add").value.toString()
               Gender.text= it.child("gender").value.toString()


            } else {
                Toast.makeText(this, "this Department id is does not exist", Toast.LENGTH_LONG)
                    .show()
            }
        }.addOnFailureListener {
            Toast.makeText(this, "Failed to get data", Toast.LENGTH_LONG).show()
        }


    }


}


