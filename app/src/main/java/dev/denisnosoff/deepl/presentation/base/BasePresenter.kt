package dev.denisnosoff.deepl.presentation.base

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import moxy.MvpPresenter

abstract class BasePresenter<View : BaseView> : MvpPresenter<View>() {

    private val mCompositeDisposable: CompositeDisposable by lazy { CompositeDisposable() }

    protected fun Disposable.connect() {
        mCompositeDisposable.add(this)
    }

    override fun onDestroy() {
        mCompositeDisposable.clear()
        super.onDestroy()
    }

}