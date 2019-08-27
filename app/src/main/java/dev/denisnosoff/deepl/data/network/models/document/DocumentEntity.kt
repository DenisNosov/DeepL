package dev.denisnosoff.deepl.data.network.models.document

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DocumentEntity(
    @PrimaryKey val id: String,
    val title: String,
    val key: String
)