package com.mj.motivationalquotes.models.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mj.motivationalquotes.api.QuotesApi
import com.mj.motivationalquotes.local.db.QuoteDao
import com.mj.motivationalquotes.models.QuoteList

class QuoteRepository(private val api: QuotesApi, private val quoteDao: QuoteDao) {

   private val _quotes = MutableLiveData<QuoteList>()
    val quotes : LiveData<QuoteList>
    get() = _quotes

    suspend fun getQuotes()
    {
        val quotesResponse = api.getQuotes(1)
        if(quotesResponse.body() != null){
            quoteDao.addQuotes(quotesResponse.body()!!.results)
            _quotes.postValue(quotesResponse.body())
        }


    }
}