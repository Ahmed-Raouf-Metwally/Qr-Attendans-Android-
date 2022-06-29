package com.example.myapplication.user

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.myapplication.R
import com.example.myapplication.api.ApiManager
import com.example.myapplication.model.LogInResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileActivity : AppCompatActivity() {
    lateinit var signOutButton: Button
    lateinit var stuName :TextView
    lateinit var stuEmail : TextView
    lateinit var stuLevel : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        signOutButton = findViewById(R.id.sign_out_button)
        stuName = findViewById(R.id.name_profile_view)
        stuEmail = findViewById(R.id.email_prof_view)
        stuLevel = findViewById(R.id.level_prof_view)
        stuName.setText(LogInResponse?.name)
        stuEmail.setText(LogInResponse?.email)
        stuLevel.setText(LogInResponse?.level.toString())
        signOutButton.setOnClickListener {
            ApiManager.getApis().Logout(stu).enqueue(object : Callback<LogInResponse> {
                override fun onResponse(
                    call: Call<LogInResponse>,
                    response: Response<LogInResponse>
                ) {

                    val intent = Intent(applicationContext,SignIn::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)

                }

                override fun onFailure(call: Call<LogInResponse>, t: Throwable) {
                    Toast.makeText(applicationContext, "sorry try again later", Toast.LENGTH_SHORT).show()
                }
            })

        }
    }
}