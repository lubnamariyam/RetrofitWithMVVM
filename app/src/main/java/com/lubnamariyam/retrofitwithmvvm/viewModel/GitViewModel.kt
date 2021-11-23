package com.lubnamariyam.retrofitwithmvvm.viewModel

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lubnamariyam.retrofitwithmvvm.model.response.GitHubData
import com.lubnamariyam.retrofitwithmvvm.network.RetrofitInstance
import com.lubnamariyam.retrofitwithmvvm.network.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GitViewModel : ViewModel() {
    var gitHubDataList = MutableLiveData<List<GitHubData>>()

    fun getApiData(){
        /*val retrofitInstance = RetrofitInstance.getRetrofitInstance().create(RetrofitService::class.java)*/
        val retrofitInstance = RetrofitInstance.getRetrofitInstance().create(RetrofitService::class.java)
        retrofitInstance.getDataFromApi().enqueue(object : Callback<List<GitHubData>>{
            override fun onResponse(
                call: Call<List<GitHubData>>,
                response: Response<List<GitHubData>>
            ) {
                gitHubDataList.value = response.body()
            }

            override fun onFailure(call: Call<List<GitHubData>>, t: Throwable) {

            }

        })

    }

}