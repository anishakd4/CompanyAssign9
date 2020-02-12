package com.developer.anishakd4.ymedialabstest

import android.util.Log
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.developer.anishakd4.ymedialabstest.adapters.RecyclerviewAdapter
import com.developer.anishakd4.ymedialabstest.models.VariantGroupsModel
import com.developer.anishakd4.ymedialabstest.models.VariationsModel

@BindingAdapter("listdata")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<VariantGroupsModel>?){
    Log.i("anisham","anisham bindRecyclerView ${data?.size}")
    val adapter = recyclerView.adapter as RecyclerviewAdapter
    adapter.submitList(data)
}