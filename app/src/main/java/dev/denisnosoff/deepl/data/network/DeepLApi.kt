package dev.denisnosoff.deepl.data.network

import dev.denisnosoff.deepl.data.network.models.translation.TranslationResponse
import io.reactivex.Single
import retrofit2.http.POST
import retrofit2.http.Part

interface DeepLApi {

    @POST("translate")
    fun translateText(
        @Part("text") text: String,
        @Part("target_lang") targetLang: String,
        @Part("source_lang") sourceLanguage: String?
    ) : Single<TranslationResponse>

}