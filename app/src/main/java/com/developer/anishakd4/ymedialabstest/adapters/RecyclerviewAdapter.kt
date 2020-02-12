package com.developer.anishakd4.ymedialabstest.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.developer.anishakd4.ymedialabstest.databinding.ListItemBinding
import com.developer.anishakd4.ymedialabstest.models.VariantGroupsModel
import com.developer.anishakd4.ymedialabstest.models.VariationsModel

class RecyclerviewAdapter : ListAdapter<VariantGroupsModel, RecyclerviewAdapter.MyViewHolder>(DiffCallBack) {

    companion object DiffCallBack : DiffUtil.ItemCallback<VariantGroupsModel>() {
        override fun areItemsTheSame(oldItem: VariantGroupsModel, newItem: VariantGroupsModel): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: VariantGroupsModel, newItem: VariantGroupsModel): Boolean {
            return oldItem.group_id.equals(newItem.group_id)
        }
    }

    class MyViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(variantGroupsModel: VariantGroupsModel) {
            binding.item = variantGroupsModel
            binding.radioList.adapter = RadioListAdapter()
        }

        companion object {
            fun from(parent: ViewGroup): MyViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding: ListItemBinding = ListItemBinding.inflate(layoutInflater, parent, false)
                return MyViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}