package com.example.iriscubeapp.presenter

import com.example.iriscubeapp.contract.ContractInterface

class Presenter(_view: ContractInterface.View,model : ContractInterface.Model): ContractInterface.Presenter {

    private var view: ContractInterface.View = _view
    private var model: ContractInterface.Model = model

    init {
        view.initView()
    }

    override fun incrementValue() {
        view.updateViewData()
    }


}