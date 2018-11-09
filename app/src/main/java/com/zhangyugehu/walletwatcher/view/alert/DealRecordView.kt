package com.zhangyugehu.walletwatcher.view.alert

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import com.zhangyugehu.walletwatcher.R
import kotlinx.android.synthetic.main.layout_record_view.view.*

class DealRecordView(var context: Context?) {
    interface RecordListener{
        fun record(money: Double, timestamp: Long, description: String)
    }

    private val contentView:View = LayoutInflater.from(context).inflate(R.layout.layout_record_view, null, false)
    init {
        contentView.dateEditor.setText(System.currentTimeMillis().toString())
    }

    fun setRecordListener(listener: RecordListener){
        contentView.recordBtn.setOnClickListener {
            listener.record(
                java.lang.Double.parseDouble(contentView.moneyEditor.text.toString()),
                java.lang.Long.parseLong(contentView.dateEditor.text.toString()),
                contentView.descEditor.text.toString()
            )
        }
    }
    fun get():View{
        return contentView
    }
}