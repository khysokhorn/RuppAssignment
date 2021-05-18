package com.rupp.fe.ruppassignment.view.fragment

import android.app.ProgressDialog
import android.content.Intent
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.rupp.fe.ruppassignment.R
import com.rupp.fe.ruppassignment.adapter.EventAdapter
import com.rupp.fe.ruppassignment.databinding.FragmentEventBinding
import com.rupp.fe.ruppassignment.factory.BaseViewModelFactory
import com.rupp.fe.ruppassignment.model.eventModel.ItemModel
import com.rupp.fe.ruppassignment.utils.Custom
import com.rupp.fe.ruppassignment.utils.IntentConst
import com.rupp.fe.ruppassignment.utils.ItemOnClick
import com.rupp.fe.ruppassignment.utils.Status
import com.rupp.fe.ruppassignment.view.activity.screen.EventDetailActivity
import com.rupp.fe.ruppassignment.viewModel.EventViewModel


class EventFragment :
    BaseFragment<FragmentEventBinding>() {
    lateinit var custom: Custom
    lateinit var eventViewModel: EventViewModel
    lateinit var eventAdapter: EventAdapter
    lateinit var progressBar: ProgressDialog
    override fun getViewBind(): FragmentEventBinding = FragmentEventBinding.inflate(layoutInflater)

    override fun initView() {
        activity!!.title = "Event"
        custom = Custom(context!!)
        eventViewModel = EventViewModel(context!!)
        eventAdapter = EventAdapter()
        eventAdapter.model = ArrayList() // in case no data
        progressBar = ProgressDialog(context)
        setHasOptionsMenu(true)
    }


    override fun onViewCreated() {
        binding.rcyEventList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = eventAdapter
        }
        eventAdapter.itemOnClick = object : ItemOnClick {
            override fun <D> onItemClick(data: D) {
                val item = data as ItemModel
                val intent = Intent(context, EventDetailActivity::class.java)
                intent.putExtra(IntentConst.eventModel, item)
                startActivity(intent)
            }
        }
    }

    override fun loadData() {
        super.loadData()
        val baseViewModelFactory = BaseViewModelFactory()
        baseViewModelFactory.context = context
        val viewModelFactory = baseViewModelFactory.create(EventViewModel::class.java)

        viewModelFactory.getAllEvent().observe(this, Observer {

            // set data to adapter for our recyclerview here
            Log.d(TAG, "loadData: data $it")
            when (it.status) {
                Status.LOADING -> {
                    binding.progressBar1.root.visibility = View.VISIBLE
                }
                Status.SUCCESS -> {
                    eventAdapter.model = it.data?.itemModels!!
                    binding.progressBar1.root.visibility = View.GONE
                }
                Status.ERROR -> {
                    binding.progressBar1.root.visibility = View.GONE
                }
            }
            eventAdapter.notifyDataSetChanged()

        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.event_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.acCreate -> Log.d(TAG, "onOptionsItemSelected: creae ")
        }
        return true
    }


}


//    // post event
//    private fun postEvent(body: String) {
//        Log.d(TAG, "postEvent: event body $body")
//        val viewModel = BaseViewModelFactory().create(EventViewModel::class.java)
//        viewModel.postCreateEvent(body).observe(this,
//            Observer {
//                when (it.status) {
//                    Status.LOADING -> {
//                        binding.btnAddEvent.visibility = View.GONE
//                        binding.prgPost.visibility = View.VISIBLE
//                    }
//                    Status.SUCCESS -> {
//                        binding.btnAddEvent.visibility = View.VISIBLE
//                        binding.prgPost.visibility = View.GONE
//                        Log.d(TAG, "postEvent: post event ${it.data}")
//                        custom.showSuccessDialog("Success", it.message).show()
//                    }
//                    Status.ERROR -> {
//                        binding.btnAddEvent.visibility = View.VISIBLE
//                        binding.prgPost.visibility = View.GONE
//                        custom.showSnackBar(binding.root, "${it.message}")
//                    }
//                }
//            })
//    }
