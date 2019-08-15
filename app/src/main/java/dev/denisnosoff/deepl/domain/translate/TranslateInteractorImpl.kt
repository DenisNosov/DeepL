package dev.denisnosoff.deepl.domain.translate

import dev.denisnosoff.deepl.data.network.models.translation.TranslationModel
import dev.denisnosoff.deepl.data.repository.translate.ITranslateRepository
import io.reactivex.Single

class TranslateInteractorImpl(
    private val translateRepository: ITranslateRepository,
    private val mapper: TranslationMapper
) : ITranslateInteractor {

    override fun translateText(
        text: String,
        targetLanguage: String,
        sourceLanguage: String?
    ): Single<TranslationModel> {
        return translateRepository.launchTextTranslation(text, targetLanguage, sourceLanguage)
            .map { mapper.mapTranslation(it) }
    }
}