package com.shaon2016.meldcxandroidtest.view.secondary

import com.shaon2016.meldcxandroidtest.base.BaseViewHolder
import com.shaon2016.meldcxandroidtest.base.IAdapterListener
import com.shaon2016.meldcxandroidtest.data.local.db.entity.History
import com.shaon2016.meldcxandroidtest.databinding.RvHistoryRowBinding
import android.graphics.BitmapFactory

class HistoryListRvVH(private val v: RvHistoryRowBinding) : BaseViewHolder(v.root) {
    override fun <T> onBind(position: Int, model: T, mCallback: IAdapterListener) {
        model as History

        val bitmap =
            BitmapFactory.decodeByteArray(model.imageByteArray, 0, model.imageByteArray.size)
        v.iv.setImageBitmap(bitmap)

        v.tvUrl.text = model.url
        v.tvDate.text = model.time

        v.ivDelete.setOnClickListener {
            mCallback.clickListener(position, model, it)
        }
        v.tvUrl.setOnClickListener {
            mCallback.clickListener(position, model, it)
        }
        v.iv.setOnClickListener {
            mCallback.clickListener(position, model, it)
        }
    }
}