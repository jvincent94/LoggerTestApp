package com.loggertestapp.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.loggertestapp.model.LoggerTableModel

@Database(entities = arrayOf(LoggerTableModel::class), version = 1, exportSchema = false)
abstract class LoggerDatabase : RoomDatabase() {

    abstract fun LogDao() : DAOAccess

    companion object {
        @Volatile
        private var INSTANCE: LoggerDatabase? = null

        fun getDatabaseClient(context: Context) : LoggerDatabase {

            if (INSTANCE != null) return INSTANCE!!

            synchronized(this) {

                INSTANCE = Room
                    .databaseBuilder(context, LoggerDatabase::class.java, "LOG_DATABASE")
                    .fallbackToDestructiveMigration()
                    .build()

                return INSTANCE!!

            }
        }
    }
}