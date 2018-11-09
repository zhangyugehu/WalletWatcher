package com.zhangyugehu.walletwatcher.view.alert

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.PopupWindow

class PopupWindowBuilder(var context: Context?) {

    private lateinit var popupWindow: PopupWindow

    private var width:Int = 0
    private var height:Int = 0
    private var contentView:View? = null
    private var isTouchable:Boolean = false

    fun setHeight(h: Int): PopupWindowBuilder{
        height = h
        return this
    }
    fun setWidth(w: Int): PopupWindowBuilder{
        width = w
        return this
    }
    fun setView(view: View): PopupWindowBuilder{
        contentView = view
        return this
    }
    fun setViewID(id: Int): PopupWindowBuilder{
        contentView = LayoutInflater.from(context).inflate(id, null, false)
        return this
    }
    fun setTouchable(flag:Boolean): PopupWindowBuilder{
        isTouchable = flag
        return this
    }
    fun setTouchinterceptor(listener: View.OnTouchListener): PopupWindowBuilder{
        return this
    }
    fun setClippingEnabled(flag: Boolean): PopupWindowBuilder{
        return this
    }

    fun build():PopupWindow{
        popupWindow = PopupWindow(contentView)
        if(width == 0) width = popupWindow.contentView.measuredWidth
        if(height == 0) height = popupWindow.contentView.measuredHeight
        popupWindow.width = width
        popupWindow.height = height
        return popupWindow
    }
}