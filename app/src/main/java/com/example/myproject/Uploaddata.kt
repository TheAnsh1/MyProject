package com.example.myproject

class Uploaddata {
    var name:String =""
    var email:String =""
    var phoneno:String =""
    var department:String =""
    var add:String =""
    var gender:String =""
  constructor(){}
    constructor(
        name:String,
        email:String,
        phoneno:String,
        department:String,
        add:String,
        gender:String

    )
    {
        this.name =name
        this.email =email
        this.phoneno=phoneno
        this.department=department
        this.add=add
        this.gender=gender

    }
}