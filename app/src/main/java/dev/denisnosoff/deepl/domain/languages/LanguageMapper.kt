package dev.denisnosoff.deepl.domain.languages

import dev.denisnosoff.deepl.R

class LanguageMapper {

    fun mapLanguagesFromUI(language: String) : Int {
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
}