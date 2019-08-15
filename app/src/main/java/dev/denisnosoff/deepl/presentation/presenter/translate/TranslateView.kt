package dev.denisnosoff.deepl.presentation.presenter.translate

import dev.denisnosoff.deepl.data.network.models.translation.TranslationModel
import dev.denisnosoff.deepl.presentation.base.BaseView
import dev.denisnosoff.deepl.presentation.base.ILoadingView

interface TranslateView : BaseView, ILoadingView {

    fun showTranslation(translationModel: TranslationModel)

}