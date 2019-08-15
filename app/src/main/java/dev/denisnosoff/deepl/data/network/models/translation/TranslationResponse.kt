package dev.denisnosoff.deepl.data.network.models.translation

import com.google.gson.annotations.SerializedName

data class TranslationResponse (

    @SerializedName("translations") val translationList: List<Translation>

) {
    data class Translation (

        @SerializedName("detected_source_language")
        val sourceLanguage: String? = null,

        @SerializedName("text")
        val text: String

    )
}