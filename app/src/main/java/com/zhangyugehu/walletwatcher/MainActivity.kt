package com.zhangyugehu.walletwatcher

import android.graphics.drawable.Drawable
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.zhangyugehu.walletwatcher.fragment.MainFragment
import com.zhangyugehu.walletwatcher.fragment.MineFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainFragment.OnFragmentInteractionListener,
    MineFragment.OnFragmentInteractionListener {
    override fun onFragmentInteraction(uri: Uri) {
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initTabHost()
    }

    private fun initTabHost() {
        mTabHost.setup(this, supportFragmentManager, R.id.main_content)
        // 去除分割线
        mTabHost.tabWidget.showDividers = LinearLayout.SHOW_DIVIDER_NONE
        addTab("主页", resources.getDrawable(R.drawable.ic_home), MainFragment::class.java)
        addTab("我", resources.getDrawable(R.drawable.ic_mine), MineFragment::class.java)

    }

    private fun addTab(title: String, indicatorDrawable: Drawable, clazz: Class<out Fragment>, args: Bundle?=null) {
        val itemPanel = LayoutInflater.from(this).inflate(R.layout.item_tab_panel, null, false)
        val imageView = itemPanel.findViewById<ImageView>(R.id.imageView)
        val textView = itemPanel.findViewById<TextView>(R.id.textView)
        textView.text = title
        imageView.setImageDrawable(indicatorDrawable)
        val tabSpec = mTabHost.newTabSpec(title).setIndicator(itemPanel)
        mTabHost.addTab(tabSpec, clazz, args)
    }

}
