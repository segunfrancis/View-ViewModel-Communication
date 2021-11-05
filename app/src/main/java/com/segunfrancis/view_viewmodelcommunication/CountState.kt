package com.segunfrancis.view_viewmodelcommunication

sealed class CountState<out T> {
    data class Success<T>(val count: T): CountState<T>()
    data class Warning<T>(val message: String, val count: T): CountState<T>()
}
