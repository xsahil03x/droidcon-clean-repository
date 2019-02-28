package com.droidcon.cleanrepository.kx

import androidx.lifecycle.*
import androidx.lifecycle.Lifecycle.Event.*
import androidx.lifecycle.Lifecycle.State.*
import io.reactivex.disposables.Disposable

fun Disposable.bindToLifecycle(lifecycleOwner: LifecycleOwner): Disposable {
    val lifecycle = lifecycleOwner.lifecycle
    val subscriptionState = lifecycle.currentState
    lifecycle.addObserver(LifecycleEventObserver { _, e ->
        if (shouldDispose(subscriptionState, e))
            try {
                dispose()
            } catch (_: Exception) {
            }
    })
    return this
}

private fun shouldDispose(subscriptionState: Lifecycle.State, stateEvent: Lifecycle.Event?) =
    when (stateEvent) {
        ON_PAUSE -> subscriptionState == STARTED || subscriptionState == RESUMED
        ON_STOP -> subscriptionState == CREATED
        ON_DESTROY -> true
        else -> false
    }




