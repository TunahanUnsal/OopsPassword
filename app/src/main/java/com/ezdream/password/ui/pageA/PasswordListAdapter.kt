package com.ezdream.password.ui.pageA

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ezdream.password.databinding.ItemPasswordBinding
import com.ezdream.password.model.PasswordModel


class PasswordListAdapter(private val itemClickListener: ItemClickListener) :
    ListAdapter<PasswordModel, PasswordListAdapter.ViewHolder>(ToDoDiffCallBack()) {
    class ViewHolder(private val binding: ItemPasswordBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(itemClickListener: ItemClickListener, passwordModel: PasswordModel) {
            binding.passwordModel = passwordModel
            binding.onItemClickListener = itemClickListener

            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val binding = ItemPasswordBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )

                return ViewHolder(binding)
            }
        }

    }

    private class ToDoDiffCallBack : DiffUtil.ItemCallback<PasswordModel>() {
        override fun areItemsTheSame(oldItem: PasswordModel, newItem: PasswordModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: PasswordModel, newItem: PasswordModel): Boolean {
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