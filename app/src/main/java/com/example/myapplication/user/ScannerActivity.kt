package com.example.myapplication.user

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.budiyev.android.codescanner.AutoFocusMode
import com.budiyev.android.codescanner.CodeScanner
import com.budiyev.android.codescanner.CodeScannerView
import com.budiyev.android.codescanner.DecodeCallback
import com.budiyev.android.codescanner.ErrorCallback
import com.budiyev.android.codescanner.ScanMode
import com.example.myapplication.MainActivity
import com.example.myapplication.R
import com.example.myapplication.api.ApiManager
import com.example.myapplication.model.AttendanceRequest
import com.example.myapplication.model.AttendanceResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

var scanned : String? = null
var matId : String? =null
var topicId : String? = null
var stuId :String?=null
class ScannerActivity : AppCompatActivity() {
    lateinit var coedScanner: CodeScanner
    lateinit var codeScannerView: CodeScannerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scanner)

        codeScannerView = findViewById<CodeScannerView>(R.id.scan_block)

    codeScanner()

        stuId = LogInResponse?.iD.toString()

    }
    private fun codeScanner(){
        coedScanner = CodeScanner(this,codeScannerView)
        coedScanner.apply {
            camera = CodeScanner.CAMERA_BACK
            formats= CodeScanner.ALL_FORMATS
            autoFocusMode = AutoFocusMode.SAFE
            scanMode= ScanMode.CONTINUOUS
            isAutoFocusEnabled = true
            isFlashEnabled = false
            decodeCallback = DecodeCallback {
                runOnUiThread{
                  scanned = it.text
                    val ss: List<String>? = scanned?.split("-")
                    matId = ss?.get(0)
                    topicId= ss?.get(1)
                    println(stuId)
                    println(topicId)
                    println(matId)
                    Toast.makeText(applicationContext, "Ok", Toast.LENGTH_SHORT).show()
                    makeReques()
                }
            }
            errorCallback = ErrorCallback {
                runOnUiThread{
                    Log.e("scannerActivitiy","error in scanActivity ${it.message} ")
                }
            }
        }

    }



    override fun onResume() {
        super.onResume()
        coedScanner.startPreview()
    }

    override fun onPause() {
        super.onPause()
        coedScanner.releaseResources()
    }
    private fun makeReques() {
        ApiManager.getApis().attend(AttendanceRequest(matId , topicId  , stuId )).enqueue(object :Callback<AttendanceResponse>{
            override fun onResponse(
                call: Call<AttendanceResponse>,
                response: Response<AttendanceResponse>
            ) {

                Toast.makeText(applicationContext, response.body()?.message, Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: Call<AttendanceResponse>, t: Throwable) {
                Toast.makeText(applicationContext, "network issue", Toast.LENGTH_SHORT).show()
            }
        })
        val intent = Intent(applicationContext, MainActivity::class.java).apply {
            startActivity(this)
        }
    }

}