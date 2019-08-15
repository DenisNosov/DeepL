package dev.denisnosoff.deepl.presentation.base

import moxy.MvpView

interface BaseView : MvpView {

    fun showError(stringId: Int)

    fun showError(text: String)
}