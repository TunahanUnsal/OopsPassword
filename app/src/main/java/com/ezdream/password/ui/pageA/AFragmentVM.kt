package com.ezdream.password.ui.pageA

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.ezdream.password.data.Repository
import com.ezdream.password.model.PasswordModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AFragmentVM @Inject constructor(
    application: Application,
    repository: Repository
) : AndroidViewModel(application) {

    val passwordList = repository.localDataSource.getAllPassword().asLiveData()

}