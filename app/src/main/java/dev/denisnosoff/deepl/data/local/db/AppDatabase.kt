package dev.denisnosoff.deepl.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.denisnosoff.deepl.data.network.models.document.DocumentEntity

@Database(entities = [DocumentEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun documentDao(): DocumentDao

    companion object {
        const val NAME = "document-database"
    }
}