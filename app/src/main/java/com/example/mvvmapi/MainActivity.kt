package com.example.mvvmapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //recyclerview.setHasFixedSize(true)
       recyclerview.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        viewModel = ViewModelProviders.of(this).get(MyViewModel::class.java)

        var adapter = recycler_adapter()

        val data = Observer<Market> {
            if(it!= null)
            {
                recyclerview.visibility = View.VISIBLE
                recyclerview.adapter = adapter
                    adapter.setData(it.markets)
            }
        }
        viewModel.callAPI().observe(this,data)
    }
}

