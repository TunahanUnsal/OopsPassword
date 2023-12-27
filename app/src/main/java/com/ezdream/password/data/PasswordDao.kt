package com.ezdream.password.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.ezdream.password.model.PasswordModel
import kotlinx.coroutines.flow.Flow

@Dao
interface PasswordDao {
    @Query("SELECT * from password_table")
    fun getAllPassword(): Flow<List<PasswordModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertToDo(passwordModel: PasswordModel)

    @Update
    suspend fun updatePassword(passwordModel: PasswordModel)

    @Query("SELECT * FROM password_table WHERE id=:passwordId")
    suspend fun getPassword(passwordId: Int): PasswordModel

    @Delete
    suspend fun deletePassword(passwordModel: PasswordModel)
}