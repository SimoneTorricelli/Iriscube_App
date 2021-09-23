package com.example.iriscubeapp.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.iriscubeapp.R

class MainActivity : AppCompatActivity() {
    /**
     * [AppCompatActivity] functions
     * */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.mainActivityFragmentContainer,FirstFragment()).commit()
        //navigateToNetworkTest()
    }


    /**
     * Private functions
     * */
    private fun navigateToNetworkTest() {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.mainActivityFragmentContainer, NetworkTestFragment.newInstance(), NetworkTestFragment.TAG)
                .commit()
    }
}