package com.developer.anishakd4.ymedialabstest.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.developer.anishakd4.ymedialabstest.databinding.RadioListItemBinding
import com.developer.anishakd4.ymedialabstest.models.VariationsModel

class RadioListAdapter : ListAdapter<VariationsModel, RadioListAdapter.RadioViewHolder>(DiffCallBack) {

    var lastSelectedPosition = 0

    companion object DiffCallBack : DiffUtil.ItemCallback<VariationsModel>() {
        override fun areItemsTheSame(oldItem: VariationsModel, newItem: VariationsModel): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: VariationsModel, newItem: VariationsModel): Boolean {
            return oldItem.id.equals(newItem.id)
        }
    }

    class RadioViewHolder(val binding: RadioListItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(variationsModel: VariationsModel) {
            binding.item = variationsModel
        }

        companion object {
            fun from(parent: ViewGroup): RadioViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding: RadioListItemBinding = RadioListItemBinding.inflate(layoutInflater, parent, false)
                return RadioViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RadioViewHolder {
        return RadioViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: RadioViewHolder, position: Int) {
        holder.bind(getItem(position))
        holder.binding.radioButton.isChecked = (lastSelectedPosition == position)
        holder.binding.radioButton.setOnClickListener {
            lastSelectedPosition = position;
            notifyDataSetChanged()
        }
    }
}