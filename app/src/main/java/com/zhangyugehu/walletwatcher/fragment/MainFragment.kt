package com.zhangyugehu.walletwatcher.fragment

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupWindow
import android.widget.Toast

import com.zhangyugehu.walletwatcher.R
import com.zhangyugehu.walletwatcher.db.litepal.tables.Deal
import com.zhangyugehu.walletwatcher.presenter.DealPresenter
import com.zhangyugehu.walletwatcher.view.alert.DealRecordView
import com.zhangyugehu.walletwatcher.view.alert.PopupWindowBuilder
import com.zhangyugehu.walletwatcher.viewholder.DealViewHolder
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment(), DealViewHolder {
    override fun context(): Context? {
        return context
    }

    private lateinit var presenter: DealPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = DealPresenter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        floatingActionButton.setOnClickListener {
            val contentView = DealRecordView(this@MainFragment.context)
            contentView.setRecordListener(object : DealRecordView.RecordListener{
                override fun record(money: Double, timestamp: Long, description: String) {
                    presenter.insertDeal(Deal.newBuilder()
                        .description(description)
                        .type(0)
                        .money(money)
                        .build()
                    )
                }
            })
//            PopupWindowBuilder(this@MainFragment.context)
//                .setView(contentView.get())
//                .build()
//                .showAsDropDown(view)
            val realContentView = contentView.get()
            val popupWindow = PopupWindow(realContentView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true)
            popupWindow.isOutsideTouchable = true
            popupWindow.showAtLocation(view, Gravity.CENTER, 0,0)
        }
        recyclerView.adapter = presenter.adapter()
        recyclerView.layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
        recyclerView.addItemDecoration(DividerItemDecoration(this.context, DividerItemDecoration.VERTICAL))

        presenter.findAll()
    }
}
