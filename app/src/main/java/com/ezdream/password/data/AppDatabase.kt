package com.ezdream.password.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ezdream.password.model.PasswordModel


@Database(entities = [PasswordModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun passwordDao(): PasswordDao
}