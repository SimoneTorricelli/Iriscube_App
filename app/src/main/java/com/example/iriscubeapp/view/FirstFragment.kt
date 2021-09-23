package com.example.iriscubeapp.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.exampleapp.recycleBankMovement.HeaderAdapter
import com.example.exampleapp.recycleBankMovement.RecycleMovementAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exampleapp.recycleBankMovement.MovementListViewModel
import com.example.exampleapp.recycleBankMovement.MovementsListViewModelFactory
import com.example.iriscubeapp.R
import SampleData
import android.view.animation.AnimationUtils
import androidx.cardview.widget.CardView
import kotlinx.android.synthetic.main.fragment_first.*

const val FLOWER_ID = "movement id"

class FirstFragment : Fragment() {

    private val newMovementActivityRequestCode = 1
    private val movementsListViewModel by viewModels<MovementListViewModel> {
        MovementsListViewModelFactory(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_first, container, false)

        val ttb = AnimationUtils.loadAnimation(context,R.anim.start_anim)
        val stb = AnimationUtils.loadAnimation(context,R.anim.start_anim_cardview2)
        val cardView : CardView = view.findViewById(R.id.cardView)
        val cardViewMoney : CardView = view.findViewById(R.id.cardViewMoney)

        cardView.startAnimation(ttb)
        cardViewMoney.startAnimation(stb)

        val headerAdapter = HeaderAdapter()
        val movementAdapter = RecycleMovementAdapter { sampleData -> adapterOnClick(sampleData) }
        val recyclerView: RecyclerView = view.findViewById(R.id.recycle_view)
        recyclerView?.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = movementAdapter



        movementsListViewModel.movementData.observe(viewLifecycleOwner, {
            it?.let {
                movementAdapter.submitList(it as MutableList<SampleData>)
                headerAdapter.updateMovementCount(it.size)
            }
        })

        /*val fab: View = view.findViewById(R.id.fab)
        fab.setOnClickListener {
            fabOnClick()
        }*/

        return view
    }


    private fun adapterOnClick(movement: SampleData) {

        /*
        val intent = Intent(this, MovementDetailActivity()::class.java)
        intent.putExtra(MOVEMENT_ID, movement.id)
        startActivity(intent)
        */

    }

    /* Adds sampleMovementData to MovementList when FAB is clicked. */
    private fun fabOnClick() {
        println("Fab Pressed")
        //val intent = Intent(this, AddMovementActivity::class.java)
        //startActivityForResult(intent, newMovementActivityRequestCode)
    }



    override fun onActivityResult(requestCode: Int, resultCode: Int, intentData: Intent?) {
        super.onActivityResult(requestCode, resultCode, intentData)

        /* Inserts movement into viewModel. */
        if (requestCode == newMovementActivityRequestCode && resultCode == Activity.RESULT_OK) {
            intentData?.let {
                val movementName = "t"
                val movementDescription = "d"
                val movementValue = 1.0

                movementsListViewModel.insertMovement(movementName, movementDescription,movementValue)
            }
        }
    }

}