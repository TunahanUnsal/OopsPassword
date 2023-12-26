package com.ezdream.password.model

data class ExampleModel(
    val id:Int,
    val name: String
){
    fun areContentsTheSame(newItem: ExampleModel): Boolean {
        return this.id == newItem.id
    }
}