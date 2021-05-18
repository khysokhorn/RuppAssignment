package com.rupp.fe.ruppassignment.view.fragment

import android.content.Intent
import android.util.Log
import com.rupp.fe.ruppassignment.adapter.EventAdapter
import com.rupp.fe.ruppassignment.databinding.FragmentDashboardBinding
import com.rupp.fe.ruppassignment.model.eventModel.ItemModel
import com.rupp.fe.ruppassignment.utils.ItemOnClick
import com.rupp.fe.ruppassignment.view.activity.screen.EventDetailActivity

class DashboardFragment : BaseFragment<FragmentDashboardBinding>() {

    override fun getViewBind(): FragmentDashboardBinding =
        FragmentDashboardBinding.inflate(layoutInflater)

    private val eventAdapter = EventAdapter()
    override fun initView() {

    }

    override fun onViewCreated() {
        eventAdapter.itemOnClick = object : ItemOnClick {
            override fun <D> onItemClick(data: D) {
                val itemModel: ItemModel = data as ItemModel
                val intent = Intent(context, EventDetailActivity::class.java)
                intent.putExtra("eventID", itemModel.id)
                startActivity(intent)
                Log.d(TAG, "onItemClick: item click $itemModel")
            }
        }
    }

    override fun loadData() {
        super.loadData()

    }


}