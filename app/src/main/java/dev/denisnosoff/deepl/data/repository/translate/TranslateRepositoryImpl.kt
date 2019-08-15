package dev.denisnosoff.deepl.data.repository.translate

import dev.denisnosoff.deepl.data.network.DeepLApi
import dev.denisnosoff.deepl.data.network.models.translation.TranslationResponse
import io.reactivex.Single
import java.util.concurrent.TimeUnit

class TranslateRepositoryImpl(
    private val api: DeepLApi
) : ITranslateRepository {

    override fun launchTextTranslation(
        text: String,
        targetLanguage: String,
        sourceLanguage: String?
    ): Single<TranslationResponse> {
//        return api.translateText(
//            text = text,
//            targetLang = targetLanguage,
//            sourceLanguage = sourceLanguage
//        )
        return Single.just(
            TranslationResponse(
                listOf(
                    TranslationResponse.Translation("RU", "Hello")
                )
            )
        ).delay(1, TimeUnit.SECONDS)
    }
}