package dev.denisnosoff.deepl.di

import dev.denisnosoff.deepl.data.local.ResourceProvider
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {
    single { ResourceProvider(androidContext()) }
}