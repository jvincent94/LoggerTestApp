package com.loggertestapp.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.loggertestapp.model.LoggerTableModel

@Dao
interface DAOAccess {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun InsertLog(loggerTableModel: LoggerTableModel)

    @Query("SELECT * FROM logs")
    fun getLogs() : LiveData<List<LoggerTableModel>>
}