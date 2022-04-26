package com.maciel.murillo.mealz.utils

import androidx.lifecycle.Observer

open class SingleLiveEvent<out T>(private val content: T) {

    var hasBeenHandled = false
        private set // Allow external read but not write

    fun getContentIfNotHandled(): T? {
        return if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            content
        }
    }

    fun peekContent(): T = content
}

class EventObserver<T>(
    private val onEventUnhandledContent: (T) -> Unit
) : Observer<SingleLiveEvent<T>> {
    override fun onChanged(event: SingleLiveEvent<T>?) {
        event?.getContentIfNotHandled()?.let { value ->
            onEventUnhandledContent(value)
        }
    }
}