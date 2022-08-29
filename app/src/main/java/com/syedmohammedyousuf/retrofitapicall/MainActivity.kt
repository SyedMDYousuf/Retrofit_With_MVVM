package com.syedmohammedyousuf.retrofitapicall

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.ViewModelInitializer
import androidx.recyclerview.widget.LinearLayoutManager
import com.syedmohammedyousuf.retrofitapicall.adapter.GithubAdapter
import com.syedmohammedyousuf.retrofitapicall.model.GithubResponse
import com.syedmohammedyousuf.retrofitapicall.viewmodel.GithubViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var githubViewModel: GithubViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initGithubApi()
    }

    fun initGithubApi(){
        githubViewModel = ViewModelProvider(this).get(GithubViewModel::class.java)
        githubViewModel.getApiData() //call api frm viewmodel

        //livedata observer

        githubViewModel.githubDataList.observe(this, Observer{
            initAdapter(it)
        })
    }
    private fun initAdapter(data: List<GithubResponse>){
        rvGithubList.layoutManager = LinearLayoutManager(this)
        val adapter = GithubAdapter(data)
        rvGithubList.adapter = adapter

    }
}