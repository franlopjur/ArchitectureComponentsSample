package com.betabeers.architecturecomponentsexample.ui.activity

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.betabeers.architecturecomponentsexample.R
import com.betabeers.architecturecomponentsexample.ui.viewmodel.SearchRepoViewModel
import com.betabeers.architecturecomponentsexample.model.domain.GithubRepoDomain
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: SearchRepoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpViewModel()

        mainBtnSearch.setOnClickListener {
            viewModel.search(mainInputSearch.text.toString())
        }
    }

    fun setUpViewModel() {
        viewModel = ViewModelProviders.of(this)
            .get(SearchRepoViewModel::class.java)

        viewModel.searchReposLiveData.observe(this, Observer<List<GithubRepoDomain>> {
            Toast.makeText(this, "list: ${it?.size}", Toast.LENGTH_SHORT).show()
        })

        viewModel.errorMessageLiveData.observe(this, Observer<String> {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })
    }
}
