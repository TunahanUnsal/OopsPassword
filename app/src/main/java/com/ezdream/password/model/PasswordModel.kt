package com.ezdream.password.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "password_table")
data class PasswordModel(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String?,
    val username: String?,
    val password: String?
) {
    fun areContentsTheSame(newItem: PasswordModel): Boolean {
        return this.title == newItem.title && this.username == newItem.username
                && this.password == newItem.password
    }
}