package com.example.testcode

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testcode.databinding.LayoutMainBinding
import com.wiik.module_startadapter.smartadapter.SmartAdapter
import com.wiik.module_startadapter.smartadapter.SmartViewHolder
import com.example.testcode.ui.MyTextFactory


class MainActivity : ComponentActivity() {
    lateinit var binding: LayoutMainBinding;

    var call: ((Int, Int) -> Int)? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_main)
        binding = DataBindingUtil.setContentView<LayoutMainBinding>(this, R.layout.layout_main)

        binding.btnLoad.setOnClickListener {
            var adapter =
                com.wiik.module_startadapter.smartadapter.SmartAdapter<com.wiik.module_startadapter.smartadapter.SmartViewHolder<*>>(
                    applicationContext
                )
            adapter.addItemFactory(MyTextFactory())
            adapter.addDataList(false,getData())
            var manager=LinearLayoutManager(applicationContext)
            manager.orientation=LinearLayoutManager.VERTICAL
            binding.recyeleviewData.layoutManager=manager
            binding.recyeleviewData.adapter=adapter
            adapter.notifyDataSetChanged()


        }


    }


    private fun getData(): MutableList<String> {
        val data = mutableListOf<String>()
        for (index in 1..100) {
            data.add("这个是第${index}数据")
        }
        return data
    }


    fun addCallBack(call: ((Int, Int) -> Int)?) {
        this.call = call
    }
}


