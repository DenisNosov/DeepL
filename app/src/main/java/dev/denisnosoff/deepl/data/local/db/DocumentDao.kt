package dev.denisnosoff.deepl.data.local.db

import androidx.room.*
import dev.denisnosoff.deepl.data.network.models.document.DocumentEntity
import io.reactivex.Observable

@Dao
interface DocumentDao {

    @Query("SELECT * FROM DocumentEntity")
    fun getAllDocuments(): Observable<List<DocumentEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg documents: DocumentEntity)

    @Query("DELETE FROM DocumentEntity WHERE id = :id")
    fun delete(id: Int)

    @Delete
    fun delete(document: DocumentEntity)

}