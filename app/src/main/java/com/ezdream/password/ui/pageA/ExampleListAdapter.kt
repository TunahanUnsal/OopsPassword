package com.ezdream.password.ui.pageA

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ezdream.password.databinding.ItemExampleBinding
import com.ezdream.password.model.ExampleModel


class ExampleListAdapter(private val itemClickListener: ItemClickListener) :
    ListAdapter<ExampleModel, ExampleListAdapter.ViewHolder>(ToDoDiffCallBack()) {
    class ViewHolder(private val binding: ItemExampleBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(itemClickListener: ItemClickListener, exampleModel: ExampleModel) {
            binding.exampleModel = exampleModel
            binding.onItemClickListener = itemClickListener

            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val binding = ItemExampleBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )

                return ViewHolder(binding)
            }
        }

    }

    private class ToDoDiffCallBack : DiffUtil.ItemCallback<ExampleModel>() {
        override fun areItemsTheSame(oldItem: ExampleModel, newItem: ExampleModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ExampleModel, newItem: ExampleModel): Boolean {
            return oldItem.areContentsTheSame(newItem)
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder.from(parent)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(itemClickListener, currentList[position])
    }
}

interface ItemClickListener {
    fun onClick(id: Int)
}