package com.example.iriscubeapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.FragmentTransaction
import com.example.iriscubeapp.R

class SecondFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_second, container, false)

        val prevBtn : Button? = view.findViewById(R.id.previous)!!
        prevBtn!!.setOnClickListener {
            val fragment = FirstFragment() //navigate to first fragment
            val ft: FragmentTransaction? = activity?.supportFragmentManager?.beginTransaction()
            ft?.setCustomAnimations(R.anim.slide_in,R.anim.fade_out)
            ft?.replace(R.id.mainActivityFragmentContainer,fragment)?.commit()
        }
        return view
    }


}