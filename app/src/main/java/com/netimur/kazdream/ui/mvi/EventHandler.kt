package com.netimur.kazdream.ui.mvi

interface EventHandler<in Event> {
    fun handleEvent(event: Event)
}