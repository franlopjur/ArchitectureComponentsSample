package com.betabeers.architecturecomponentsexample.ui.activity

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.arch.paging.PagedList
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.betabeers.architecturecomponentsexample.R
import com.betabeers.architecturecomponentsexample.ui.viewmodel.SearchRepoViewModel
import com.betabeers.architecturecomponentsexample.model.domain.GithubRepoDomain
import com.betabeers.architecturecomponentsexample.ui.adapter.GithubRepoAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: SearchRepoViewModel
    private var adapter: GithubRepoAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpAdapter()
        setUpViewModel()

        mainBtnSearch.setOnClickListener {
            viewModel.updateQuery(mainInputSearch.text.toString())
        }
    }

    private fun setUpAdapter() {
        adapter = GithubRepoAdapter {position, repo ->
            Toast.makeText(this, repo.name, Toast.LENGTH_SHORT).show()
        }
        mainRecycler.adapter = adapter
    }

    fun setUpViewModel() {
        viewModel = ViewModelProviders.of(this)
            .get(SearchRepoViewModel::class.java)

        viewModel.githubReposListLiveData.observe(this,
            Observer<PagedList<GithubRepoDomain>> {
            adapter?.submitList(it)
        })

        viewModel.errorMessageLiveData.observe(this,
            Observer<String> {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })
    }
}
