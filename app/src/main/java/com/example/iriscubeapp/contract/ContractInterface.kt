package com.example.iriscubeapp.contract

import SampleData
import android.content.Context
import androidx.lifecycle.MutableLiveData

interface ContractInterface {

    interface View {
        fun initView()
        fun updateViewData()
    }

    interface Presenter {
        fun incrementValue()
    }

    interface Model {
        fun getMovementList(context: Context): MutableLiveData<List<SampleData>>
    }

}