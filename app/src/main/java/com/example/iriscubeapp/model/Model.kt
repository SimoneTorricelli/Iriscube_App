package com.example.iriscubeapp.model

import SampleData
import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.iriscubeapp.contract.ContractInterface
import kotlinx.coroutines.*
import movementDatas

class Model(context: Context) : ContractInterface.Model{

    private suspend fun takeList(context: Context) = coroutineScope {
        val initialMovementList = movementDatas(context)
        val movementLiveData = MutableLiveData(initialMovementList)
        delay(1000L)
        println("Passato 1 secondo invio")
        return@coroutineScope movementLiveData
    }

    override fun getMovementList(context: Context): MutableLiveData<List<SampleData>> = runBlocking(CoroutineName("MakeList") + Dispatchers.Default) {
        println("[${Thread.currentThread().name}]")
        return@runBlocking takeList(context)
    }


}