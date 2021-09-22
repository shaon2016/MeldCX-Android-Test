package com.shaon2016.meldcxandroidtest.base


import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class BaseRecyclerAdapter<T>(
    mContext: Context?,
    mListener: IAdapterListener,
    datas: ArrayList<T>
) :
    RecyclerView.Adapter<BaseViewHolder>() {

    var context: Context? = mContext
    var listener: IAdapterListener = mListener
    var datas = datas
    lateinit var holder: BaseViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return listener.getViewHolder(parent, viewType)
    }

    override fun getItemCount() = datas.size

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        if (datas.size > 0) {
            this.holder = holder
            this.holder.onBind(position, datas.get(position), listener)
        }
    }

    fun addData(datas: ArrayList<T>) {
        this.datas.addAll(datas)
        notifyDataSetChanged()
    }

    fun removeData(datas: ArrayList<T>) {
        this.datas.clear()
        notifyDataSetChanged()
    }

    fun addData(data: T) {
        this.datas.add(data)
        notifyDataSetChanged()
    }

    fun removeData(position: Int) {
        this.datas.removeAt(position)
        notifyItemRemoved(position)
    }

    fun clear() {
        datas.clear()
        notifyDataSetChanged()
    }


}