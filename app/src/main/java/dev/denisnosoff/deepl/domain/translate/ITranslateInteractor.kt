package dev.denisnosoff.deepl.domain.translate

import dev.denisnosoff.deepl.data.network.models.translation.TranslationModel
import io.reactivex.Single

interface ITranslateInteractor {

    fun translateText(text: String, targetLanguage: String, sourceLanguage: String? = null) : Single<TranslationModel>

}