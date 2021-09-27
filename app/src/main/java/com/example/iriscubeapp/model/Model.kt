package com.example.iriscubeapp.model

import com.example.iriscubeapp.contract.ContractInterface

class Model : ContractInterface.Model{
    private var mCounter = 0

    override fun getCounter()= mCounter

    override fun incrementCounter() {
        mCounter++
    }
}