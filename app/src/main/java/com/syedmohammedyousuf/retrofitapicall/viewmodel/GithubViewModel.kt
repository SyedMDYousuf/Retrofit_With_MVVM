package com.syedmohammedyousuf.retrofitapicall.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.syedmohammedyousuf.retrofitapicall.model.GithubResponse
import com.syedmohammedyousuf.retrofitapicall.network.RetrofitInstance
import com.syedmohammedyousuf.retrofitapicall.network.RetrofitService
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class GithubViewModel : ViewModel() {

    var githubDataList = MutableLiveData<List<GithubResponse>>()


    fun getApiData(){

        val retrofitService = RetrofitInstance.getRetrofitInstance().create(RetrofitService::class.java)

        retrofitService.getData().enqueue(object : retrofit2.Callback<List<GithubResponse>>{

            override fun onResponse(
                call: Call<List<GithubResponse>>,
                response: Response<List<GithubResponse>>
            ) {
                githubDataList.value = response.body()
            }

            override fun onFailure(call: Call<List<GithubResponse>>, t: Throwable) {

            }


        })
    }

}

private fun <T> Call<T>.enqueue(any: Any) {

}
