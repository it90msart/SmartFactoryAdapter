package com.wiik.module_startadapter.smartadapter

import android.content.Context
import android.view.View
import androidx.databinding.ViewDataBinding

import androidx.recyclerview.widget.RecyclerView

/**
 * <pre>
 *     author : zhaoyx
 *     time   : 2023/7/28 15:10
 *     version: 1.0
 *     desc   :
 * </pre>
 */
abstract class SmartViewHolder<T : ViewDataBinding,out DATA>(val parent: View?, val bind: T?) :
    RecyclerView.ViewHolder(if (bind == null) parent!! else bind.root) {


    fun getmContext(): Context? {
        if (bind != null)
            return bind.root.context
        return parent!!.context
    }


    abstract fun initView(context: Context?)


    abstract fun  bindViewData(any: @UnsafeVariance DATA?, position: Int);




}