package com.lubnamariyam.retrofitwithmvvm.network

import com.lubnamariyam.retrofitwithmvvm.model.response.GitHubData
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {

    @GET("/repos/octocat/hello-world/issues")
    fun getDataFromApi(): Call<List<GitHubData>>

}