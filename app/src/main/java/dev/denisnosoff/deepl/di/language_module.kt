package dev.denisnosoff.deepl.di

import dev.denisnosoff.deepl.domain.languages.ILanguagesRepository
import dev.denisnosoff.deepl.data.repository.languages.LanguagesRepositoryImpl
import dev.denisnosoff.deepl.domain.languages.ILanguagesInteractor
import dev.denisnosoff.deepl.domain.languages.LanguageMapper
import dev.denisnosoff.deepl.domain.languages.LanguagesInteractorImpl
import org.koin.dsl.module

val languageModule = module {
    single { LanguageMapper() }
    single { LanguagesRepositoryImpl() as ILanguagesRepository }
    single { LanguagesInteractorImpl() as ILanguagesInteractor }
}