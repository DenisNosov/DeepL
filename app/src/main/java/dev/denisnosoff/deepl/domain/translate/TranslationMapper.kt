package dev.denisnosoff.deepl.domain.translate

import dev.denisnosoff.deepl.data.network.models.translation.TranslationModel
import dev.denisnosoff.deepl.data.network.models.translation.TranslationResponse

class TranslationMapper {

    fun mapTranslation(response: TranslationResponse) : TranslationModel {
        val resultText = StringBuilder()
        response.translationList.forEach{ translation ->
            resultText.append(translation.text)
        }
        return TranslationModel(
            response.translationList[0].sourceLanguage,
            resultText.toString()
        )
    }

}