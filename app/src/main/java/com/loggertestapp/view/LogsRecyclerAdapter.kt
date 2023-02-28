package com.loggertestapp.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.loggertestapp.R
import com.loggertestapp.model.LoggerTableModel

class LogsRecyclerAdapter(): RecyclerView.Adapter<LogsRecyclerAdapter.LogsViewHolder>() {

    private var logs: List<LoggerTableModel> = ArrayList()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LogsRecyclerAdapter.LogsViewHolder {
        var root = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return LogsViewHolder(root)
    }

    override fun onBindViewHolder(holder: LogsRecyclerAdapter.LogsViewHolder, position: Int) {
        val currentLog = logs[position]
        holder.textViewButtonName.text = currentLog.buttonName
        holder.textViewTimeStamp.text = currentLog.timestamp
    }

    fun setLogs(logs: List<LoggerTableModel>) {
        this.logs = logs
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return logs.size
    }

    inner class LogsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textViewButtonName: TextView = itemView.findViewById(R.id.tvButtonName)
        var textViewTimeStamp: TextView = itemView.findViewById(R.id.tvTimestamp)
    }
}