package com.ezdream.password.data

import com.ezdream.password.model.PasswordModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject



class LocalDataSource @Inject constructor(
    private val passwordDao: PasswordDao
) {

    fun getAllPassword(): Flow<List<PasswordModel>> {
        return passwordDao.getAllPassword()
    }


    suspend fun insertPassword(passwordModel: PasswordModel) {
        passwordDao.insertToDo(passwordModel)
    }

    suspend fun getPassword(passwordId: Int): PasswordModel {
        return passwordDao.getPassword(passwordId)
    }

    suspend fun updatePassword(passwordModel: PasswordModel) {
        passwordDao.updatePassword(passwordModel)
    }

    suspend fun deletePassword(passwordModel: PasswordModel) {
        passwordDao.deletePassword(passwordModel)
    }
}