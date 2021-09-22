package com.shaon2016.meldcxandroidtest.view.secondary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.shaon2016.meldcxandroidtest.R
import com.shaon2016.meldcxandroidtest.base.BaseActivity
import com.shaon2016.meldcxandroidtest.base.BaseRecyclerAdapter
import com.shaon2016.meldcxandroidtest.base.BaseViewHolder
import com.shaon2016.meldcxandroidtest.base.IAdapterListener
import com.shaon2016.meldcxandroidtest.data.local.db.entity.History
import com.shaon2016.meldcxandroidtest.databinding.ActivitySecondaryBinding
import com.shaon2016.meldcxandroidtest.databinding.RvHistoryRowBinding

class SecondaryActivity : BaseActivity() {
    private lateinit var binding: ActivitySecondaryBinding
    private val vm by viewModels<SecondaryVM>()

    private val adapter by lazy {
        BaseRecyclerAdapter(this, object : IAdapterListener {
            override fun <T> clickListener(position: Int, model: T, view: View) {

                model as History

                when (view.id) {
                    R.id.ivDelete -> {
                        removeAItem(position)
                    }
                }
            }

            override fun getViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
                return HistoryListRvVH(
                    RvHistoryRowBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
        }, ArrayList<History>())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondaryBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun viewRelatedTask() {
        title = "History"

        initRv()
    }

    private fun initRv() {
        binding.rv.layoutManager = LinearLayoutManager(this)
        binding.rv.adapter = adapter

        vm.histories.observe(this) {
            it?.let {
                adapter.addData(it as ArrayList<History>)
            }
        }
    }

    private fun removeAItem(position: Int) {
        vm.remove(adapter.datas[position])
        adapter.removeData(position)
    }

}