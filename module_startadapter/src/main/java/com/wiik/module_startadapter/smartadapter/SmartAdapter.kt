package com.wiik.module_startadapter.smartadapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * <pre>
 *     author : zhaoyx
 *     time   : 2023/7/28 14:45
 *     version: 1.0
 *     desc   :
 * </pre>
 */
class SmartAdapter<VH : RecyclerView.ViewHolder>(val context: Context?) :
    RecyclerView.Adapter<VH>() {

    //从0开始,类型索引
    private var typeIndex = 0;

    private var dataTypeList = mutableListOf<SmartItemViewFactory>()

    private var dataList = mutableListOf<Any?>()
    private val map: HashMap<Int, SmartItemViewFactory> by lazy { HashMap() }

    public fun <T : SmartItemViewFactory> addItemFactory(factory: T) {

        if (!map.containsKey(typeIndex)) {
            map.put(typeIndex, factory)
            typeIndex++
        } else {
            typeIndex++
            map.put(typeIndex, factory)
        }

    }

    public fun addDataList(cleanOldList: Boolean, list: MutableList<*>) {

        if (cleanOldList) {
            dataList.apply {
                this.clear()
            }
        }

        var befoSize = dataList.size
        if (!list.isNullOrEmpty()) {
            dataList.apply {
                if (dataList == null) {
                    dataList = mutableListOf()
                }
                befoSize = dataList.size
                dataList.addAll(list)
            }
        }
        if (cleanOldList) {
            notifyDataSetChanged()
        } else {
            notifyItemRangeChanged(befoSize, list.size)
        }

    }


    public fun addDataItem(item: Any?) {
        dataList.apply {
            if (dataList == null) {
                dataList = mutableListOf()
            }
            val oldSize =
                dataList.size
            dataList.add(item)
            notifyItemRangeChanged(oldSize, 1)
        }
    }

    public fun getDataList(): MutableList<*>? {
        return dataList
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val factory = map.get(viewType)

        val inflat = LayoutInflater.from(context)
        val hdoler = factory!!.createViewHolder(parent, inflat) as VH

        if (hdoler is SmartViewHolder<*, *>) {
            hdoler.initView(context)
        }
        return hdoler

    }


    override fun onBindViewHolder(holder: VH, position: Int) {
        val baseHolder = holder as SmartViewHolder<*, *>

        val data:Any?=getItem(position);
        baseHolder.bindViewData(data, position)
    }

    override fun getItemViewType(position: Int): Int {
        //当前item的位置
        val dataItem: Any? = dataList.get(position)

        var type = -1

        //根据item命中对应得布局
        for (key in map.keys) {
            val factory = map.get(key)

            if (factory != null && factory.dataItemType(dataItem)) {
                type = key
                break
            }
        }

        if (type != -1) {
            return type
        } else {
            throw IllegalStateException("undefine is type,or factory,please check your adapter is addItemFactory=${dataItem.toString()}")
        }


        return 0
    }

    //获取当前位置的factory
    public fun getFactory(position: Int): SmartItemViewFactory? {
        //当前item的位置
        val dataItem: Any? = dataList.get(position)

        var mFactory: SmartItemViewFactory? = null

        //根据item命中对应得布局
        for (key in map.keys) {
            val factory = map.get(key)

            if (factory != null && factory.dataItemType(dataItem)) {
                mFactory = factory
                break
            }
        }

        return mFactory

    }

    public fun getItem(position: Int): Any? {
        return dataList.run {
            if (dataList.isNullOrEmpty()) null else dataList.get(position)
        }
    }

    override fun getItemCount(): Int {
        return dataTypeList.run { if (dataList == null) 0 else dataList.size }

    }
}