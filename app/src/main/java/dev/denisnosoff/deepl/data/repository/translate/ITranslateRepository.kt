package dev.denisnosoff.deepl.data.repository.translate

import dev.denisnosoff.deepl.data.network.models.translation.TranslationResponse
import io.reactivex.Single

interface ITranslateRepository {

    fun launchTextTranslation(text: String, targetLanguage: String, sourceLanguage: String?) : Single<TranslationResponse>

}