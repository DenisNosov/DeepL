package dev.denisnosoff.deepl.domain.languages

import dev.denisnosoff.deepl.R
import dev.denisnosoff.deepl.data.local.ResourceProvider

class LanguageMapper(
    private val resourceProvider: ResourceProvider
) {

    fun mapLanguagesFromUI(language: String): Int {
        return when (language) {
            "EN" -> R.string.english
            "DE" -> R.string.german
            "FR" -> R.string.french
            "ES" -> R.string.spanish
            "PT" -> R.string.portuguese
            "IT" -> R.string.italian
            "NL" -> R.string.dutch
            "PL" -> R.string.polish
            "RU" -> R.string.russian
            else -> R.string.unknown
        }
    }

    fun getDisplayedLanguageByResponse(language: String): String {
        return when (language) {
            "EN" -> resourceProvider.getString(R.string.english)
            "DE" -> resourceProvider.getString(R.string.german)
            "FR" -> resourceProvider.getString(R.string.french)
            "ES" -> resourceProvider.getString(R.string.spanish)
            "PT" -> resourceProvider.getString(R.string.portuguese)
            "IT" -> resourceProvider.getString(R.string.italian)
            "NL" -> resourceProvider.getString(R.string.dutch)
            "PL" -> resourceProvider.getString(R.string.polish)
            "RU" -> resourceProvider.getString(R.string.russian)
            else -> resourceProvider.getString(R.string.unknown)
        }
    }
}