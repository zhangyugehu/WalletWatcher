package com.zhangyugehu.walletwatcher.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zhangyugehu.walletwatcher.R
import com.zhangyugehu.walletwatcher.db.litepal.tables.Deal
import com.zhangyugehu.walletwatcher.presenter.DealPresenter
import kotlinx.android.synthetic.main.adapter_deal.view.*
import java.text.SimpleDateFormat
import java.util.*

class DealAdapter(var presenter: DealPresenter, var context: Context?, var deals: MutableList<Deal>):
    RecyclerView.Adapter<DealAdapter.Holder>() {


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.adapter_deal, p0, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return this.deals.size
    }

    override fun onBindViewHolder(holder: Holder, p1: Int) {
        holder.setDeal(this.deals[p1])
    }

    class Holder(itemView: View): RecyclerView.ViewHolder(itemView) {

        @SuppressLint("SetTextI18n")
        fun setDeal(deal: Deal){
            itemView.apply {
                moneyText.text = "￥ ${deal.money}"
                descText.text = deal.description
                dateText.text = SimpleDateFormat("MM-dd hh:mm", Locale("zh-CN")).format(deal.time)
            }

        }
    }
}