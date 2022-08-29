package com.syedmohammedyousuf.retrofitapicall.network

import com.syedmohammedyousuf.retrofitapicall.model.GithubResponse
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {

    @GET("/repos/octocat/hello-world/issues")
    fun getData(): Call<List<GithubResponse>>
}