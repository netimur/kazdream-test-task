package com.netimur.kazdream.ui.mvi.screens

interface ScreenContentProducer<in State> {
    fun produceScreen(state: State): ScreenContent
}