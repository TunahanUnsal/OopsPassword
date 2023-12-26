package com.ezdream.template.ui.pageA

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.ezdream.template.model.ExampleModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AFragmentVM @Inject constructor(application: Application) : AndroidViewModel(application) {
    val text = "Data binding 1"
    val exampleList = mutableListOf<ExampleModel>()

    fun addData(){
        exampleList.add(ExampleModel(1,"Tuna"))
    }

}