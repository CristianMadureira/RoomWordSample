package com.example.roomwordsample

import androidx.lifecycle.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class WordViewModel(private val wordRepository: WordRepository): ViewModel() {

    val allWords: LiveData<List<Word>> = wordRepository.allWords.asLiveData()

    fun insert(word: Word) = viewModelScope.launch {
        wordRepository.insert(word)
    }

}

class WordViewModelFactory(private val repository: WordRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(WordViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return WordViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}