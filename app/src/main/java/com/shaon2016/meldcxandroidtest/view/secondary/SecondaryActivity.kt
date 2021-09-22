package com.shaon2016.meldcxandroidtest.view.secondary

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.activity.viewModels
import androidx.core.widget.addTextChangedListener
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
                adapter.clear()
                adapter.addData(it as ArrayList<History>)
            }
        }
        doSearch()
    }

    private fun doSearch() {
        binding.evSearch.addTextChangedListener {
            it?.let {
                adapter.filterable.filter.filter(it.toString())

                if (it.toString().isEmpty()) {
                    binding.ivClear.visibility = View.GONE
                } else {
                    binding.ivClear.visibility = View.VISIBLE
                }
            }
        }

        binding.ivClear.setOnClickListener {
            binding.evSearch.setText("")
        }

        adapter.filterable = Filterable {
            object : Filter() {
                override fun performFiltering(charSequence: CharSequence): FilterResults {
                    val charString = charSequence.toString()
                    if (charString.isEmpty()) {
                        adapter.filterableItems = adapter.datas
                    } else {
                        val filteredList: ArrayList<History> = ArrayList()
                        for (row in adapter.datas) {

                            // name match condition. this might differ depending on your requirement
                            // here we are looking for name or phone number match
                            if (row.url.lowercase()
                                    .contains(charString.lowercase())
                            ) {
                                filteredList.add(row)
                            }
                        }
                        adapter.filterableItems = filteredList
                    }
                    val filterResults = FilterResults()
                    filterResults.values = adapter.filterableItems
                    return filterResults
                }

                override fun publishResults(
                    charSequence: CharSequence,
                    filterResults: FilterResults
                ) {
                    adapter.filterableItems =
                        filterResults.values as ArrayList<History>
                    adapter.notifyDataSetChanged()
                }
            }
        }
    }

    private fun removeAItem(position: Int) {
        vm.remove(adapter.datas[position])
        adapter.removeData(position)
    }

}