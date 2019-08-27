package dev.denisnosoff.deepl.di

import androidx.room.Room
import dev.denisnosoff.deepl.data.local.ResourceProvider
import dev.denisnosoff.deepl.data.local.db.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {
    single { ResourceProvider(androidContext()) }
    single { Room.databaseBuilder(androidContext(), AppDatabase::class.java, AppDatabase.NAME).build().documentDao() }
}