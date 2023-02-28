package com.loggertestapp.view

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.loggertestapp.R
import com.loggertestapp.viewmodel.LogsViewModel
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var logsViewModel: LogsViewModel
    lateinit var context: Context
    lateinit var button1: Button
    lateinit var button2: Button
    lateinit var button3: Button
    lateinit var button4: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        context = this@MainActivity
        logsViewModel = ViewModelProvider(this)[LogsViewModel::class.java]

        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)

        button1.setOnClickListener {
            logButton(button1.text.toString())
        }
        button2.setOnClickListener {
            logButton(button2.text.toString())
        }
        button3.setOnClickListener {
            logButton(button3.text.toString())
        }
        button4.setOnClickListener {
            logButton(button4.text.toString())
        }
    }

    private fun logButton(buttonName: String){
        val timeStamp: String = SimpleDateFormat("dd/MM/yyyy hh:mm aaa").format(Date())
        logsViewModel.insertDataLog(context, "$buttonName pressed", timeStamp)
        startActivity(Intent(this, LogsActivity::class.java))
    }
}