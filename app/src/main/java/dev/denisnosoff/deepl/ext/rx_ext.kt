package dev.denisnosoff.deepl.ext

import dev.denisnosoff.deepl.presentation.base.ILoadingView
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

fun <T> Single<T>.ioToUi() : Single<T> =
    subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())

fun <T> Single<T>.loading(view: ILoadingView) : Single<T> =
    doOnSubscribe { view.showLoading(true) }
        .doOnError { view.showLoading(false) }
        .doOnSuccess { view.showLoading(false) }