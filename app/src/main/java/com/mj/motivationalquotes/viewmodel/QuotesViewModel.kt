package com.mj.motivationalquotes.viewmodel

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mj.motivationalquotes.models.QuoteList
import com.mj.motivationalquotes.models.repository.QuoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class QuotesViewModel(val quoteRepository: QuoteRepository) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) { quoteRepository.getQuotes() }
    }

    val quoteList:LiveData<QuoteList>
    get() = quoteRepository.quotes
}