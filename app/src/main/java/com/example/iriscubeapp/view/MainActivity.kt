package com.example.iriscubeapp.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet
import com.example.iriscubeapp.R
import com.example.iriscubeapp.contract.ContractInterface
import com.example.iriscubeapp.model.Model
import com.example.iriscubeapp.presenter.Presenter

class MainActivity : AppCompatActivity(),ContractInterface.View{
    /**
     * [AppCompatActivity] functions
     * */

    private var presenter: Presenter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = Presenter(this, Model())
        supportFragmentManager.beginTransaction().replace(R.id.mainActivityFragmentContainer,FirstFragment()).commit()

    }

    override fun initView() {
        TODO("Not yet implemented")
    }

    override fun updateViewData() {
        TODO("Not yet implemented")
    }


}