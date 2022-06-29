package com.example.myapplication.model

class Student {
    constructor(Email: String?, Password: String?) {
        this.Email = Email
        this.Password = Password
    }

    constructor(ID: Int?) {
        this.ID = ID
        this.sID = ID
    }

    private var Email : String? = null
    private  var Password:String? = null
    private var ID: Int? = null
    private var sID:Int? = null

}