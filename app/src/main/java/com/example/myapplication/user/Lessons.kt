package com.example.myapplication.user

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.api.ApiManager
import com.example.myapplication.model.GetAllTopicResponse
import com.example.myapplication.model.Subjects
import com.example.myapplication.model.TopicsItem
import com.example.myapplication.ui.Adapters.LessonsAdapter
import com.example.myapplication.ui.dashboard.MatId
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Lessons : AppCompatActivity() {
    lateinit var lessrec: RecyclerView
    lateinit var lessAdap: LessonsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lessons)
        lessrec = findViewById(R.id.lessons_rec)
        creat()
        lessAdap = LessonsAdapter(topics)
        lessrec.adapter = lessAdap
    }
    val topics: MutableList<TopicsItem?> = mutableListOf()
    private fun creat() {
        ApiManager.getApis().getAllTopic(Subjects(MatId)).enqueue(object :
            Callback<GetAllTopicResponse> {
            override fun onResponse(
                call: Call<GetAllTopicResponse>,
                response: Response<GetAllTopicResponse>
            ) {
                lessAdap.setData(response.body()?.topics as MutableList<TopicsItem?>?)

            }

            override fun onFailure(call: Call<GetAllTopicResponse>, t: Throwable) {
                Toast.makeText(applicationContext, "network issue", Toast.LENGTH_SHORT).show()
            }

        })
      }
    }
