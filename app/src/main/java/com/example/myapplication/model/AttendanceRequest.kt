package com.example.myapplication.model

class AttendanceRequest {
    private var Mat_ID :String? = null
    private var Topic_ID: String? = null
    private var Stud_ID:String? = null

    constructor(Mat_ID: String?, Topic_ID: String?, Stud_ID: String?) {
        this.Mat_ID = Mat_ID
        this.Topic_ID = Topic_ID
        this.Stud_ID = Stud_ID
    }
}