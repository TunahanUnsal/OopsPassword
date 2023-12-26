package com.ezdream.password.util

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ezdream.password.model.ExampleModel
import com.ezdream.password.ui.pageA.ExampleListAdapter
import com.ezdream.password.ui.pageA.ItemClickListener


@BindingAdapter("list", "setOnItemClickListener")
fun setHomeRecyclerViewAdapter(
    recyclerView: RecyclerView,
    list: List<ExampleModel>?,
    itemClickListener: ItemClickListener,
) {
    recyclerView.apply {
        if (this.adapter == null) {
            adapter = ExampleListAdapter(itemClickListener).apply {
                submitList(
                    list
                )
            }
        } else {
            (this.adapter as ExampleListAdapter).submitList(
                list
            )
        }
    }
}
