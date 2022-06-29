package com.example.myapplication.api


import com.example.myapplication.model.LogInResponse
import com.example.myapplication.model.Student
import com.example.myapplication.model.SubjectsResponse
import retrofit2.Call
import retrofit2.http.*
import retrofit2.http.FormUrlEncoded

interface Services {


    @POST("logIn")
    fun LogIn(
        @Body stu : Student
    ):Call<LogInResponse> ;
    @POST("logout")
    fun Logout(
        @Body stu : Student
    ):Call<LogInResponse>
    @POST("getStmat")
    fun getStudentSubject(
        @Body stu: Student
    ):Call<SubjectsResponse>
}