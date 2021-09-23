package com.example.iriscubeapp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.android.volley.*
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.iriscubeapp.R
import kotlinx.android.synthetic.main.fragment_network_test.*
import org.json.JSONObject
import sampleData



class NetworkTestFragment : Fragment() {
    /**
     * Static constants and functions
     * */
    companion object {
        const val TAG = "NetworkTestFragment"
        fun newInstance() = NetworkTestFragment()
    }

    /**
     * [Fragment] functions
     * */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_network_test, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        nextTodoButton.setOnClickListener {
            println("clicked")
            val url = "https://mocki.io/v1/08bdd00f-c17f-4f9a-a27f-f2ec437781b9"
            val que = Volley.newRequestQueue(context)
            val jsonObjectRequest = JsonArrayRequest(Request.Method.GET, url, null,
                { response ->
                    println(response)
                    val list = Array(response.length()) {
                        response.getString(it)
                    }

                },
                { error ->
                    println(error)
                }
            )
            que.add(jsonObjectRequest)
        }
    }


}