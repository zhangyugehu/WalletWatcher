package com.zhangyugehu.walletwatcher.db.litepal.tables

import org.litepal.crud.LitePalSupport

/**
 *
 */
class Account(
    private var name: String
) : LitePalSupport() {

    private lateinit var deals: List<Deal>

    private lateinit var description: String
}