package com.example.myproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.lang.Exception
import kotlin.math.E
import kotlin.system.measureTimeMillis

class MainActivity : AppCompatActivity() {
    private lateinit var Name:EditText
    private lateinit var Phoneno:EditText
   lateinit var Email_id:EditText
    private lateinit var Document_Id:EditText
    private lateinit var Address:EditText
    private lateinit var Gender:String
    private lateinit var upload:Button
    private lateinit var Male:TextView
    private lateinit var FeMale:TextView
    private lateinit var others:TextView
    private lateinit var Read:Button

     lateinit var name:String
    lateinit var email:String
     lateinit var phone:String
     lateinit var document:String
    lateinit var add:String
   var gender:String =""
       private lateinit var ref:DatabaseReference
    lateinit var  database:FirebaseDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        setContentView(R.layout.activity_main)
        Name =findViewById(R.id.Name)
        upload =findViewById(R.id.save)
        Phoneno =findViewById(R.id.phoneno)
        Email_id =findViewById(R.id.Email)
        Document_Id =findViewById(R.id.Department)
        Address =findViewById(R.id.Address)
        Male =findViewById(R.id.male)
        FeMale =findViewById(R.id.female)
        others =findViewById(R.id.others)
        name =Name.text.toString()
        email =Email_id.text.toString()
        phone =Phoneno.toString()
        document =Document_Id.toString()
        add =Address.toString()
        Read =findViewById(R.id.Read)




        Male.setOnClickListener {
            gender ="male"
          Toast.makeText(this,"male selected"+Email_id.text.toString(),Toast.LENGTH_LONG).show()
        }
        FeMale.setOnClickListener {
            gender ="Female"
            Toast.makeText(this,"female selected"+ Email_id.text.toString(),Toast.LENGTH_LONG).show()
        }
        others.setOnClickListener {
            gender ="others"
            Toast.makeText(this,"others selected"+Email_id.text.toString(),Toast.LENGTH_LONG).show()
        }

        upload.setOnClickListener {
           val upk =email.toString()
            ref =FirebaseDatabase.getInstance().getReference("user")
            val up=Uploaddata(Name.text.toString(), Email_id.text.toString(),Phoneno.text.toString(),Document_Id.text.toString(),Address.text.toString(),gender.toString())
                ref.child(Document_Id.text.toString()).setValue(up)
            Name.text.clear()
            Email_id.text.clear()
            Phoneno.text.clear()
            Document_Id.text.clear()
            Address.text.clear()

            Toast.makeText(this,"successfully loaded",Toast.LENGTH_LONG).show()


        }
        Read.setOnClickListener {
            val intent =Intent(this,SeeDetails::class.java)
            startActivity(intent)
        }
    }




}