package com.mj.motivationalquotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.mj.motivationalquotes.api.ApiInstance
import com.mj.motivationalquotes.local.db.QuoteDatabase
import com.mj.motivationalquotes.models.repository.QuoteRepository
import com.mj.motivationalquotes.viewmodel.QuoteViewModelFactory
import com.mj.motivationalquotes.viewmodel.QuotesViewModel

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: QuotesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = QuoteRepository(ApiInstance.getQuotesApiInstance(),
            QuoteDatabase.getDatabase(applicationContext).quoteDao())

        viewModel =
            ViewModelProvider(this, QuoteViewModelFactory(repository))[QuotesViewModel::class.java]
        viewModel.quoteList.observe(this, Observer {
            Log.d("TAG", "${it.results.size}")
        })

    }
}