package com.lubnamariyam.retrofitwithmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.lubnamariyam.retrofitwithmvvm.adapter.GitHubAdapter
import com.lubnamariyam.retrofitwithmvvm.model.response.GitHubData
import com.lubnamariyam.retrofitwithmvvm.network.RetrofitInstance
import com.lubnamariyam.retrofitwithmvvm.network.RetrofitService
import com.lubnamariyam.retrofitwithmvvm.viewModel.GitViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    lateinit var githubInitViewModel: GitViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadData()

    }

    fun loadData(){
        githubInitViewModel = ViewModelProvider(this).get(GitViewModel::class.java)
        githubInitViewModel.getApiData()
        githubInitViewModel.gitHubDataList.observe(this, Observer {
            initAdapter(it)
        })
    }

    fun initAdapter(data:List<GitHubData>){
        recyclerVi.layoutManager = LinearLayoutManager(this)
        // This will pass the ArrayList to our Adapter
        val adapter = GitHubAdapter(data)
        // Setting the Adapter with the recyclerview
        recyclerVi.adapter = adapter
    }
}