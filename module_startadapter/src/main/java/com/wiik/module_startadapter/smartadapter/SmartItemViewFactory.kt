package com.wiik.module_startadapter.smartadapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding


/**
 * <pre>
 *     author : zhaoyx
 *     time   : 2023/7/28 15:05
 *     version: 1.0
 *     desc   :
 * </pre>
 */
abstract class SmartItemViewFactory {

    @LayoutRes
    abstract fun getLatouy(): Int

    //对当前data item
    abstract fun dataItemType(any: Any?): Boolean


    abstract fun createViewHolder(parent: ViewGroup?,inflat: LayoutInflater): SmartViewHolder<*>;


    public fun <V : ViewDataBinding> getViewBind(parent: ViewGroup?, inflat: LayoutInflater?): V?{
        return DataBindingUtil.inflate<V>(inflat!!, getLatouy(), parent, false)
    }


    public fun onCreateViewHolderView(parent: ViewGroup?, inflat: LayoutInflater):View?{
        return inflat.inflate(getLatouy(),parent,false)
    }

}