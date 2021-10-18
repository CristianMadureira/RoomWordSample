package com.example.roomwordsample

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query


@Dao
interface WordDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: Word)

    @Query("SELECT * from word_table ORDER BY word ASC")
    fun getAlphabetizedWords(): kotlinx.coroutines.flow.Flow<kotlin.collections.List<Word>>

    @Query("DELETE from word_table")
    suspend fun deleteAll()
}