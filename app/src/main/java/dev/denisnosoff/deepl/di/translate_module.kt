package dev.denisnosoff.deepl.di

import dev.denisnosoff.deepl.data.repository.translate.ITranslateRepository
import dev.denisnosoff.deepl.data.repository.translate.TranslateRepositoryImpl
import dev.denisnosoff.deepl.domain.translate.ITranslateInteractor
import dev.denisnosoff.deepl.domain.translate.TranslateInteractorImpl
import dev.denisnosoff.deepl.domain.translate.TranslationMapper
import org.koin.dsl.module

val translateModule = module {
    single { TranslateRepositoryImpl(get()) as ITranslateRepository }
    single { TranslateInteractorImpl(get(), get()) as ITranslateInteractor }
    single { TranslationMapper() }
}