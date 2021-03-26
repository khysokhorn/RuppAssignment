package com.rupp.fe.ruppassignment.view.activity.screen

import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.rupp.fe.ruppassignment.R
import com.rupp.fe.ruppassignment.adapter.EventListAdapter
import com.rupp.fe.ruppassignment.adapter.FeedItemBinder
import com.rupp.fe.ruppassignment.adapter.FeedItemClass
import com.rupp.fe.ruppassignment.databinding.ActivityEventListBinding
import com.rupp.fe.ruppassignment.factory.BaseViewModelFactory
import com.rupp.fe.ruppassignment.utils.Status
import com.rupp.fe.ruppassignment.view.activity.BaseActivity
import com.rupp.fe.ruppassignment.viewModel.GGCEventViewModel

class EventListActivity : BaseActivity<ActivityEventListBinding>() {
    private val TAG = "EventListActivity"
    private var adapter: EventListAdapter? = null

    override fun loadData() {
        val viewModelFactory = BaseViewModelFactory().create(GGCEventViewModel::class.java)
        viewModelFactory.getAllVentList().observe(this, Observer { it ->
            when (it.status) {
                Status.SUCCESS -> Log.d(TAG, "loadData: success with ${
                    it.data?.items?.map { item ->
                        Log.d(TAG, "loadData: item description ${item.description} summary ${item.summary}")
                       
                    }
                }")
                Status.ERROR -> Log.d(TAG, "loadData: error with ${it.message}")
                Status.LOADING -> Log.d(TAG, "loadData: loading...")

            }
        })
    }

    override fun getViewBind(): ActivityEventListBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_event_list);

    override fun initView() {

        binding.rcyListItem.apply {
            layoutManager = LinearLayoutManager(this@EventListActivity)

        }
    }


}