package com.shaon2016.meldcxandroidtest.base

import android.view.View
import android.view.ViewGroup

/**
 * This is a helper adapter listener
 * Used to load viewholder from activity or fragment and
 * get listener from view holder class that implements it
 * */
interface IAdapterListener {
    fun <T> clickListener(position: Int, model: T, view: View)
    fun  getViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder
}