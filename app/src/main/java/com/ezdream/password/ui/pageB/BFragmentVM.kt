package com.ezdream.password.ui.pageB

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.ezdream.password.data.Repository
import com.ezdream.password.model.PasswordModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BFragmentVM @Inject constructor(
    application: Application,
    private val repository: Repository
) : AndroidViewModel(application) {

    var passwordModel = MutableLiveData<PasswordModel>()

    fun addNewPassword(passwordModel: PasswordModel) {
        viewModelScope.launch {
            repository.localDataSource.insertPassword(passwordModel)
        }
    }

    fun updatePassword(passwordModel: PasswordModel) {
        viewModelScope.launch {
            repository.localDataSource.updatePassword(passwordModel)
        }
    }

    fun deletePassword() {
        viewModelScope.launch {
            passwordModel.value?.let { repository.localDataSource.deletePassword(it) }
        }
    }

    fun getPassword(passwordId: Int) {
        viewModelScope.launch {
            passwordModel.value = repository.localDataSource.getPassword(passwordId)
            Log.i("TAG", "getPassword: ${passwordModel.value}")
        }
    }

}