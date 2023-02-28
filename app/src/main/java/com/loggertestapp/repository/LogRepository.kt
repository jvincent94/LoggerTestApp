package com.loggertestapp.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.loggertestapp.model.LoggerTableModel
import com.loggertestapp.room.LoggerDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class LogRepository {

    companion object {
        var loggerDatabase: LoggerDatabase? = null
        var loggerTableModel: LiveData<List<LoggerTableModel>>? = null

        fun initDB(context: Context) : LoggerDatabase {
            return LoggerDatabase.getDatabaseClient(context)
        }

        fun insertLog(context: Context, buttonName: String, timestamp: String) {
            loggerDatabase = initDB(context)

            CoroutineScope(IO).launch {
                val logDetails = LoggerTableModel(buttonName, timestamp)
                loggerDatabase!!.LogDao().InsertLog(logDetails)
            }
        }

        fun getLogsDetails(context: Context) : LiveData<List<LoggerTableModel>> {
            loggerDatabase = initDB(context)
            loggerTableModel = loggerDatabase!!.LogDao().getLogs()
            return loggerTableModel as LiveData<List<LoggerTableModel>>
        }



    }
}