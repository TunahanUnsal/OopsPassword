package com.ezdream.password.ui.pageA

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.ezdream.password.model.PasswordModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AFragmentVM @Inject constructor(application: Application) : AndroidViewModel(application) {
    val passwordList = mutableListOf<PasswordModel>()

    fun addData(){
        passwordList.add(PasswordModel(1,"Ziraat Mobil","2828472738283","asdasdqweqwe123"))
        passwordList.add(PasswordModel(1,"Gmail","tuna.maeglini@gmail.com","asdasdqweqwe123"))
        passwordList.add(PasswordModel(1,"Amazon","5436351536","asdasdqweqwe123"))
    }

}