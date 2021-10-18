package com.example.roomwordsample

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.SupervisorJob

@InternalCoroutinesApi
class WordsApplication : Application() {

    val applicatioScope = CoroutineScope(SupervisorJob())

    val database by lazy { WordRoomDatabase.getDatabase(this, applicatioScope) }
    val repository by lazy { WordRepository(database.wordDao()) }
}