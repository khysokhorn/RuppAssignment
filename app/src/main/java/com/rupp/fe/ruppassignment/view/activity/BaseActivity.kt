package com.rupp.fe.ruppassignment.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<B : ViewBinding> : AppCompatActivity() {
    protected val TAG = javaClass.name
    lateinit var binding: B
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = getViewBind()
        setContentView(binding.root)
        initView()
        loadData()
    }

    abstract fun loadData();
    abstract fun getViewBind(): B
    abstract fun initView();
}