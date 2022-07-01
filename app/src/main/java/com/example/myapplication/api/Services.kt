package com.example.myapplication.api


import com.example.myapplication.model.*
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
    @POST("getStAlltopic")
    fun getAllTopic(@Body Subjects:Subjects):Call<GetAllTopicResponse>
@POST("Attend")
fun attend(@Body Attendreq:AttendanceRequest):Call<AttendanceResponse>

}