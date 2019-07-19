package dev.denisnosoff.deepl.data.network

import retrofit2.http.GET
import retrofit2.http.Query

interface DeepLApi {

    @GET("translate")
    fun translateText(
        @Query("text") text: String,
        @Query("target_lang") targetLang: String,
        @Query("source_lang") sourceLanguage: String? = null
    )

}