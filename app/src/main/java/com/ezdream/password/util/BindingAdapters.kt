package com.ezdream.password.util

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ezdream.password.model.PasswordModel
import com.ezdream.password.ui.pageA.ItemClickListener
import com.ezdream.password.ui.pageA.PasswordListAdapter


@BindingAdapter("list", "setOnItemClickListener")
fun setHomeRecyclerViewAdapter(
    recyclerView: RecyclerView,
    list: List<PasswordModel>?,
    itemClickListener: ItemClickListener,
) {
    recyclerView.apply {
        if (this.adapter == null) {
            adapter = PasswordListAdapter(itemClickListener).apply {
                submitList(
                    list
                )
            }
        } else {
            (this.adapter as PasswordListAdapter).submitList(
                list
            )
        }
    }
}
