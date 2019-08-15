package dev.denisnosoff.deepl.data.network.models.translation

import com.google.gson.annotations.SerializedName

data class TranslationModel(

    val sourceLanguage: String?,

    val text: String

)