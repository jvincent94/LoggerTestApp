package com.loggertestapp.view

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.loggertestapp.R
import com.loggertestapp.model.LoggerTableModel
import com.loggertestapp.viewmodel.LogsViewModel
import java.util.logging.Logger

class LogsActivity : AppCompatActivity() {

    private lateinit var logsViewModel: LogsViewModel
    private val adapter = LogsRecyclerAdapter()
    lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logs)

        context = this@LogsActivity
        val recyclerView = findViewById<RecyclerView>(R.id.recycler)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter
        logsViewModel = ViewModelProvider(this)[LogsViewModel::class.java]
        logsViewModel.getLogDetails(context)?.observe(this,
            Observer<List<LoggerTableModel>> { t  -> adapter.setLogs(t!!)})
    }
}