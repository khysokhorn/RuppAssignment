package com.rupp.fe.ruppassignment.view.activity.screen

import android.content.Intent
import androidx.core.text.HtmlCompat
import androidx.databinding.DataBindingUtil
import com.rupp.fe.ruppassignment.R
import com.rupp.fe.ruppassignment.databinding.ActivityEventDetailBinding
import com.rupp.fe.ruppassignment.model.eventModel.ItemModel
import com.rupp.fe.ruppassignment.utils.IntentConst
import com.rupp.fe.ruppassignment.view.activity.BaseActivity
import com.rupp.fe.ruppassignment.viewModel.EventViewModel

class EventDetailActivity : BaseActivity<ActivityEventDetailBinding>() {
    lateinit var eventViewModel: EventViewModel

    override fun loadData() {

    }

    override fun getViewBind(): ActivityEventDetailBinding =
        DataBindingUtil.setContentView(this, R.layout.activity_event_detail);

    override fun initView() {
        eventViewModel = EventViewModel(this)
        onNewIntent(intent)
        applicationContext.resources.getColor(R.color.black)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        val item = intent?.getSerializableExtra(IntentConst.eventModel) as ItemModel

        binding.tvTitle.text = item.summary
        binding.tvStartDate.text = item.start.dateTime
        binding.tvStartTime.text = item.start.dateTime
        binding.tvEndDate.text = item.end.dateTime
        binding.tvEndTime.text = item.end.dateTime
        binding.tvKindEvent.text = item.kind

        binding.tcCreatedDate.text = item.created
        binding.tcUpdatedDate.text = item.updated
        binding.tvCreatedBy.text = item.creator.email
        binding.tvOrganizer.text = item.organizer.email
        binding.tvStatus.text = item.status
        binding.tvEventType.text = item.eventType
        binding.tvDescription.text =
            HtmlCompat.fromHtml(item.description, HtmlCompat.FROM_HTML_MODE_LEGACY)
    }

}



