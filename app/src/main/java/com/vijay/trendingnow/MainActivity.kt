package com.vijay.trendingnow

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var dashboardVieModel: DashboardViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dashboardVieModel = ViewModelProviders.of(this).get(DashboardViewModel::class.java)

        val recyclerView = findViewById<RecyclerView>(R.id.rv_home)
        recyclerView.layoutManager = LinearLayoutManager(this)
        //recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        dashboardVieModel.getGoogleTrendingList().observe(this, Observer { it ->
            val x = 0
            if (recyclerView.adapter == null) {
                val adapter = RecyclerViewAdapter(this, it)
                recyclerView.adapter = adapter
            } else {
                (recyclerView.adapter as RecyclerViewAdapter).updateItems(it)
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        dashboardVieModel.deleteAllData()
    }
}
