package com.example.myapplication.user

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.myapplication.MainActivity
import com.example.myapplication.R

class SignIn : AppCompatActivity() {
lateinit var log_in:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        log_in = findViewById(R.id.log_in)
        log_in.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
           }

}