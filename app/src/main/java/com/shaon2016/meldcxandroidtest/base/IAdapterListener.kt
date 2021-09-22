package com.shaon2016.meldcxandroidtest.base

import android.view.View
import android.view.ViewGroup

interface IAdapterListener {
    fun <T> clickListener(position: Int, model: T, view: View)
    fun  getViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder
}