package com.ezdream.password.ui.pageB

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BFragmentVM @Inject constructor(application: Application) : AndroidViewModel(application) {
    var text = MutableLiveData(0)
}