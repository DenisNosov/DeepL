package dev.denisnosoff.deepl.di

import dev.denisnosoff.deepl.data.network.ApiServiceFactory
import org.koin.dsl.module

val networkModule = module {
    single { ApiServiceFactory().createApi() }
}