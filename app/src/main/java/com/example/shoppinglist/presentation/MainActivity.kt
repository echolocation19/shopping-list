package com.example.shoppinglist.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.viewModels
import com.example.shoppinglist.R
import com.example.shoppinglist.domain.ShopItem

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()


    private lateinit var llLinearLayout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        llLinearLayout = findViewById(R.id.llItems)
        viewModel.shopList.observe(this, {
            showList(it)
        })
    }

    private fun showList(list: List<ShopItem>) {
        llLinearLayout.removeAllViews()
        for (item in list) {
            val layoutId = if (item.enabled)
                R.layout.item_shop_enabled
            else
                R.layout.item_shop_disabled
            val view = LayoutInflater.from(this).inflate(layoutId, llLinearLayout, false)
            val tvName = view.findViewById<TextView>(R.id.tvName)
            tvName.text = item.name
            val tvCount =  view.findViewById<TextView>(R.id.tvCount)
            tvCount.text = item.count.toString()
            view.setOnLongClickListener {
                viewModel.changeEnableState(item)
                true
            }
            llLinearLayout.addView(view)
        }
    }
}