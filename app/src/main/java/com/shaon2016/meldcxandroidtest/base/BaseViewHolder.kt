package com.shaon2016.meldcxandroidtest.base


import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

    abstract fun<T> onBind(position: Int, model:T, mCallback : IAdapterListener)

}