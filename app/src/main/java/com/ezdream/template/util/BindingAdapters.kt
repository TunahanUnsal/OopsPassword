package com.ezdream.template.util

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ezdream.template.model.ExampleModel
import com.ezdream.template.ui.pageA.ExampleListAdapter
import com.ezdream.template.ui.pageA.ItemClickListener


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
