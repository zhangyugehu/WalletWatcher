package com.zhangyugehu.walletwatcher.db.litepal.tables

import org.litepal.crud.LitePalSupport
import java.util.*

class Deal: LitePalSupport() {

    // 0 out; 1 in
    var type: Int = 0

    var money: Double = 0.00
    var account: Account = DEFAULT_ACCOUNT
    var description: String = ""
    var time: Long = Date().time

    companion object {
        val DEFAULT_ACCOUNT:Account = Account("default account")
        fun newBuilder():Builder{
            return Builder()
        }
    }
    class Builder{
        private var type: Int = 0

        private var money: Double = 0.00
        private var account: Account = DEFAULT_ACCOUNT
        private var description: String = ""
        fun type(type:Int):Builder{
            this.type = type
            return this
        }
        fun money(money:Double):Builder{
            this.money = money
            return this
        }
        fun account(account: Account):Builder{
            this.account = account
            return this
        }
        fun description(description:String):Builder{
            this.description = description
            return this
        }
        fun build():Deal{
            var deal = Deal()
            deal.type = this.type
            deal.money = this.money
            deal.account = this.account
            deal.description = this.description
            return deal
        }
    }
}