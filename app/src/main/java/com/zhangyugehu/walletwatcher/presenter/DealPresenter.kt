package com.zhangyugehu.walletwatcher.presenter

import android.support.v7.widget.RecyclerView
import com.zhangyugehu.walletwatcher.adapter.DealAdapter
import com.zhangyugehu.walletwatcher.base.BasePresenter
import com.zhangyugehu.walletwatcher.db.litepal.tables.Deal
import com.zhangyugehu.walletwatcher.viewholder.DealViewHolder
import org.litepal.LitePal

class DealPresenter(viewHolder: DealViewHolder) : BasePresenter<DealViewHolder>(viewHolder){
    private var deals:MutableList<Deal> = ArrayList()
    private var adapter: DealAdapter? = null

    fun insertDeal(deal: Deal){
        deals.add(deal)
        adapter?.notifyItemChanged(deals.size-1)
        deal.save()
    }

    fun findAll(){
        LitePal.findAllAsync(Deal::class.java).listen { allDeal->
            deals.clear()
            deals.addAll(allDeal)
            adapter?.notifyDataSetChanged()
        }
    }

    fun adapter(): RecyclerView.Adapter<DealAdapter.Holder>? {
        if(adapter == null) {
            adapter = DealAdapter(this, viewHolder.context(), deals)
        }
        return adapter
    }
}