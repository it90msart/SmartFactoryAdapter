package com.example.testcode.factory

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.testcode.R
import com.example.testcode.bean.Product
import com.example.testcode.databinding.ProductFactoryViewBind
import com.wiik.module_startadapter.smartadapter.SmartItemViewFactory
import com.wiik.module_startadapter.smartadapter.SmartViewHolder

/**
 * <pre>
 *     author : zhaoyx
 *     time   : 2023/8/7 11:14
 *     version: 1.0
 *     desc   :
 * </pre>
 */
class ProductFactory() : SmartItemViewFactory() {
    override fun getLatouy(): Int {

        return R.layout.layout_factory_product
    }

    override fun dataItemType(any: Any?): Boolean {
        return if (any is Product) true else false
    }

    override fun createViewHolder(
        parent: ViewGroup?,
        inflat: LayoutInflater
    ): SmartViewHolder<*, *> {
        val root = onCreateViewHolderView(parent, inflat)
        val binding = getViewBind<ProductFactoryViewBind>(parent, inflat)
        return ProductFactoryHolder(root, binding)
    }

    inner class ProductFactoryHolder(root: View?, binding: ProductFactoryViewBind?) :
        SmartViewHolder<ProductFactoryViewBind, Product>(root, binding) {

        override fun initView(context: Context?) {

        }

        override fun bindViewData(any: Product?, position: Int) {

            any?.let {
                bind!!.textTitle.setText(any.title)
                bind!!.textDes.setText(any.desc)
                Glide.with(getmContext()).load(any.img).into(bind!!.productImg)

            }

        }
    }
}