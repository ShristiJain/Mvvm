package com.example.mvvmapi

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


    class MyViewModel : ViewModel() {

        fun callAPI() : MutableLiveData<Market>
        {
            return ReRepository().callAPI()
        }
    }
