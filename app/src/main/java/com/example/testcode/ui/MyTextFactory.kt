package com.example.testcode.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import com.example.testcode.R
import com.example.testcode.databinding.MyTextFactoryFactory
import com.wiik.module_startadapter.smartadapter.SmartItemViewFactory
import com.wiik.module_startadapter.smartadapter.SmartViewHolder

/**
 * <pre>
 *     author : zhaoyx
 *     time   : 2023/8/1 15:43
 *     version: 1.0
 *     desc   :
 * </pre>
 */
class MyTextFactory : com.wiik.module_startadapter.smartadapter.SmartItemViewFactory() {
    override fun getLatouy(): Int {
        return R.layout.layout_factory_view
    }

    override fun dataItemType(any: Any?): Boolean {
        if (any is String)
            return true
        return false
    }


    override fun createViewHolder(
        parent: ViewGroup?,
        inflat: LayoutInflater
    ): com.wiik.module_startadapter.smartadapter.SmartViewHolder<MyTextFactoryFactory> {

        val binding = getViewBind<MyTextFactoryFactory>(parent, inflat)
        val rootView = onCreateViewHolderView(parent, inflat)

        return MyDataViewHolder(rootView, binding)
    }

    inner class MyDataViewHolder(root: View?, bind: MyTextFactoryFactory?) :
        com.wiik.module_startadapter.smartadapter.SmartViewHolder<MyTextFactoryFactory>(root, bind) {
        override fun initView(context: Context?) {

        }

        override fun bindViewData(any: Any?, position: Int) {

            val tyext = if (any is String)
                any.toString()
            else "为null"
            bind?.textInfo?.setText(tyext)


        }
    }

}