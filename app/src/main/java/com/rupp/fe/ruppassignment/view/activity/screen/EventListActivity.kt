package com.rupp.fe.ruppassignment.view.activity.screen

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import com.rupp.fe.ruppassignment.R
import com.rupp.fe.ruppassignment.databinding.ActivityEventListBinding
import com.rupp.fe.ruppassignment.view.activity.BaseActivity
import com.rupp.fe.ruppassignment.view.fragment.DashboardFragment
import com.rupp.fe.ruppassignment.view.fragment.EventFragment
import com.rupp.fe.ruppassignment.view.fragment.QuotFragment
import com.rupp.fe.ruppassignment.view.fragment.TrackFragment

class EventListActivity : BaseActivity<ActivityEventListBinding>() {
    override fun getViewBind(): ActivityEventListBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_event_list);

    override fun loadData() {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun initView() {
        setSupportActionBar(binding.toolbar)

        val drawerToggle = ActionBarDrawerToggle(
                this, binding.drawerLayout, binding.toolbar,
                R.string.app_name, R.string.app_name
        )
        binding.drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()
        val navigationView = NavigationView.OnNavigationItemSelectedListener {
            // handle nav view
            handleNavView(it)
            binding.drawerLayout.closeDrawers()
            return@OnNavigationItemSelectedListener true
        }
        binding.navViewEvent.setNavigationItemSelectedListener(navigationView)
    }

    private fun handleNavView(item: MenuItem) {
        when (item.itemId) {
            R.id.acEvent -> showFragment(EventFragment())
            R.id.acDashboard -> showFragment(DashboardFragment())
            R.id.acTrack -> showFragment(TrackFragment())
            R.id.acQuot -> showFragment(QuotFragment())
        }
    }

    private fun showFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(binding.frmContainView.id, fragment)
        fragmentTransaction.commit()
    }
}