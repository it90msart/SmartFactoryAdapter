package com.example.testcode

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.testcode.bean.ImageBean
import com.example.testcode.bean.Product
import com.example.testcode.databinding.LayoutMainBinding
import com.example.testcode.factory.ImageFactory
import com.example.testcode.factory.ProductFactory

import com.example.testcode.ui.MyTextFactory
import com.google.android.material.divider.MaterialDividerItemDecoration
import com.wiik.module_startadapter.smartadapter.SmartAdapter
import com.wiik.module_startadapter.smartadapter.SmartViewHolder


class MainActivity : ComponentActivity() {
    lateinit var binding: LayoutMainBinding;

    var call: ((Int, Int) -> Int)? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_main)
        binding = DataBindingUtil.setContentView<LayoutMainBinding>(this, R.layout.layout_main)
        var adapter =
            SmartAdapter<SmartViewHolder<*, *>>(
                applicationContext
            )
        binding.btnLoad.setOnClickListener {
            adapter.addItemFactory(MyTextFactory())
            adapter.addItemFactory(ImageFactory())
            adapter.addItemFactory(ProductFactory())
            adapter.addDataList(false, getData())
            var manager = LinearLayoutManager(applicationContext)
            manager.orientation = LinearLayoutManager.VERTICAL
            binding.recyeleviewData.layoutManager = manager
            binding.recyeleviewData.adapter = adapter
            binding.recyeleviewData.addItemDecoration(DividerItemDecoration(this,LinearLayoutManager.VERTICAL))
            adapter.notifyDataSetChanged()

        }

        binding.btnLoadSize.setOnClickListener {
            val list = adapter.getDataList()
            if (list != null) {
                Log.e("aaa11", "${list.size}")
                Toast.makeText(applicationContext, "${list.size}", Toast.LENGTH_SHORT).show()
                for (item in list) {

                    Log.e("aaa", "${item}")
                }
            }
        }

        binding.btnLoadAdd.setOnClickListener {

            adapter.addDataItem(Product(
                "https://bs.kjcdn.com/i/pubwmrsn/6o/8w/o215p.jpg",
                "NEW ADD",
                "按实际欧普达塑胶大数据都拿手机的爱搜点击爱搜点击奥斯丁骄傲搜到角度骄傲搜ID案件次哦阿斯加德次奥超级爱哦擦剂擦肩地哦啊基地哦按ji"
            ))
        }


    }


    private fun getData(): MutableList<Any?> {
        val data = mutableListOf<Any?>()
        for (index in 1..5) {
            data.add("这个是第${index}数据")
        }


        data.add(
            Product(
                "https://bs.kjcdn.com/i/pubwmrsn/6o/8w/o215p.jpg",
                "这一个测试",
                "按实际欧普达塑胶大数据都拿手机的爱搜点击爱搜点击奥斯丁骄傲搜到角度骄傲搜ID案件次哦阿斯加德次奥超级爱哦擦剂擦肩地哦啊基地哦按ji"
            )
        )
        data.add(ImageBean("https://bs.kjcdn.com/i/pubwmrsn/6o/8w/o215o.jpg"))
        data.add(ImageBean("https://bs.kjcdn.com/i/pubwmrsn/6o/8w/o215o.jpg"))
        data.add(
            Product(
                "https://bs.kjcdn.com/i/pubwmrsn/6o/8w/o215p.jpg",
                "这一个测试",
                "按实际欧普达塑胶大数据都拿手机的爱搜点击爱搜点击奥斯丁骄傲搜到角度骄傲搜ID案件次哦阿斯加德次奥超级爱哦擦剂擦肩地哦啊基地哦按ji"
            )
        )
        data.add(ImageBean("https://bs.kjcdn.com/i/pubwmrsn/6o/8w/o215o.jpg"))

        data.add(
            Product(
                "https://bs.kjcdn.com/i/pubwmrsn/6o/8w/o215p.jpg",
                "这一个测试",
                "按实际欧普达塑胶大数据都拿手机的爱搜点击爱搜点击奥斯丁骄傲搜到角度骄傲搜ID案件次哦阿斯加德次奥超级爱哦擦剂擦肩地哦啊基地哦按ji"
            )
        )
        data.add(ImageBean("https://s.kjcdn.com/es/resource/images/cover1.png"))
        data.add(
            Product(
                "https://s.kjcdn.com/es/resource/images/cover1.png",
                "这一个测试",
                "按实际欧普达塑胶大数据都拿手机的爱搜点击爱搜点击奥斯丁骄傲搜到角度骄傲搜ID案件次哦阿斯加德次奥超级爱哦擦剂擦肩地哦啊基地哦按ji"
            )
        )
        data.add(ImageBean("https://bs.kjcdn.com/i/pubwmrsn/6o/8w/o215o.jpg"))
        data.add(ImageBean("https://s.kjcdn.com/es/resource/images/cover1.png"))
        data.add(
            Product(
                "https://bs.kjcdn.com/i/pubwmrsn/6o/8w/o215p.jpg",
                "这一个测试",
                "按实际欧普达塑胶大数据都拿手机的爱搜点击爱搜点击奥斯丁骄傲搜到角度骄傲搜ID案件次哦阿斯加德次奥超级爱哦擦剂擦肩地哦啊基地哦按ji"
            )
        )
        data.add(
            Product(
                "https://bs.kjcdn.com/i/pubwmrsn/6o/8w/o1zfb.jpg",
                "这一个测试",
                "按实际欧普达塑胶大数据都拿手机的爱搜点击爱搜点击奥斯丁骄傲搜到角度骄傲搜ID案件次哦阿斯加德次奥超级爱哦擦剂擦肩地哦啊基地哦按ji"
            )
        )
        data.add(
            Product(
                "https://bs.kjcdn.com/i/pubwmrsn/6o/8w/o215p.jpg",
                "这一个测试",
                "按实际欧普达塑胶大数据都拿手机的爱搜点击爱搜点击奥斯丁骄傲搜到角度骄傲搜ID案件次哦阿斯加德次奥超级爱哦擦剂擦肩地哦啊基地哦按ji"
            )
        )


        data.add("asdkaopdkaposdkaspodkaspodkaspodkas dkapodkaspoaskdpoas")
        data.add(
            Product(
                "https://bs.kjcdn.com/i/pubwmrsn/6o/8w/o215p.jpg",
                "这一个测试",
                "按实际欧普达塑胶大数据都拿手机的爱搜点击爱搜点击奥斯丁骄傲搜到角度骄傲搜ID案件次哦阿斯加德次奥超级爱哦擦剂擦肩地哦啊基地哦按ji"
            )
        )
        data.add(ImageBean("https://bs.kjcdn.com/i/pubwmrsn/6o/8w/o215o.jpg"))
        return data
    }


    fun addCallBack(call: ((Int, Int) -> Int)?) {
        this.call = call
    }


}


