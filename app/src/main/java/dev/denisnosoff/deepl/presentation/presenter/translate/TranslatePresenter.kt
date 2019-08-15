package dev.denisnosoff.deepl.presentation.presenter.translate

import dev.denisnosoff.deepl.R
import dev.denisnosoff.deepl.data.local.ResourceProvider
import dev.denisnosoff.deepl.domain.translate.ITranslateInteractor
import dev.denisnosoff.deepl.ext.ioToUi
import dev.denisnosoff.deepl.ext.loading
import dev.denisnosoff.deepl.presentation.base.BasePresenter
import moxy.InjectViewState

@InjectViewState
class TranslatePresenter(
    private val resourceProvider: ResourceProvider,
    private val translateInteractor: ITranslateInteractor
) : BasePresenter<TranslateView>() {

    fun translateClicked(text: String, inputLanguage: String, outputLanguage: String) {
        if (inputLanguage == resourceProvider.getString(R.string.unknown)) {
            loadTranslation(text, outputLanguage)
        } else {
            loadTranslation(text, outputLanguage, inputLanguage)
        }
    }

    private fun loadTranslation(text: String, outputLanguage: String, inputLanguage: String? = null) {
        translateInteractor.translateText(text, outputLanguage, inputLanguage)
            .ioToUi()
            .loading(viewState)
            .subscribe({ translationModel ->
                viewState.showTranslation(translationModel)
            }, {
                viewState.showError(R.string.error_while_translating)
            })
            .connect()
    }


}