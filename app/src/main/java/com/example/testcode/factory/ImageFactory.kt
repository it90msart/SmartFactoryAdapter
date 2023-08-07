package com.example.testcode.factory

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import com.bumptech.glide.Glide
import com.example.testcode.R
import com.example.testcode.bean.ImageBean
import com.example.testcode.databinding.ImageFactoryViewBind
import com.example.testcode.databinding.MyTextFactoryFactory
import com.wiik.module_startadapter.smartadapter.SmartItemViewFactory
import com.wiik.module_startadapter.smartadapter.SmartViewHolder

/**
 * <pre>
 *     author : zhaoyx
 *     time   : 2023/8/7 11:15
 *     version: 1.0
 *     desc   :
 * </pre>
 */
class ImageFactory(): SmartItemViewFactory() {

    override fun getLatouy(): Int {
        return R.layout.layout_factory_image
    }

    override fun dataItemType(any: Any?): Boolean {
        if (any is ImageBean)
            return true
        return false
    }

    override fun createViewHolder(
        parent: ViewGroup?,
        inflat: LayoutInflater
    ): SmartViewHolder<*, *> {
        val root = onCreateViewHolderView(parent, inflat)

        val binding = getViewBind<ImageFactoryViewBind>(parent, inflat)
        return FactoryViewHolder(root, binding)

    }


    inner class FactoryViewHolder(root: View?, binding: ImageFactoryViewBind?) :
        SmartViewHolder<ImageFactoryViewBind, ImageBean>(root, binding) {


        override fun initView(context: Context?) {

        }

        override fun bindViewData(any: ImageBean?, position: Int) {

            any?.let {
                Glide.with(getmContext()).load(any.url).into(bind!!.imageview)
            }


        }
    }
}