package com.loggertestapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "logs")
data class LoggerTableModel (
    @ColumnInfo(name = "buttonName")
    var buttonName: String,

    @ColumnInfo(name = "timestamp")
    var timestamp: String
){
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var Id: Int? = null
}