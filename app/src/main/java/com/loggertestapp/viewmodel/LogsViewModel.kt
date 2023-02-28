package com.loggertestapp.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.loggertestapp.model.LoggerTableModel
import com.loggertestapp.repository.LogRepository

class LogsViewModel : ViewModel() {

    var liveDataLogs: LiveData<List<LoggerTableModel>>? = null

    fun insertDataLog(context: Context, buttonName: String, timestamp: String) {
        LogRepository.insertLog(context, buttonName, timestamp)
    }

    fun getLogDetails(context: Context) : LiveData<List<LoggerTableModel>>? {
        liveDataLogs = LogRepository.getLogsDetails(context)
        return liveDataLogs
    }
}