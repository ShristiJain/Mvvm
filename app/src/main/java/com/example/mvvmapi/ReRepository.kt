package com.example.mvvmapi


import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.mvvmapi.apiService
import com.example.mvvmapi.Market
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
class ReRepository {
    fun callAPI(): MutableLiveData<Market> {
        val mutableLiveData = MutableLiveData<Market>()

        apiService().fetchData()
           .enqueue(object : Callback<Market> {
                override fun onFailure(call: Call<Market>, t: Throwable) {
                    Log.d("Error", "Coudn't get the data")

                }
                override fun onResponse(call: Call<Market>, response: Response<Market>) {
                    if (response.isSuccessful) {
                        mutableLiveData.postValue(response.body())
                        mutableLiveData.value= response.body()
                    } else {
                        Log.d("Error", "Coudn't get the data")
                    }

               }
            })
        return mutableLiveData
    }
}