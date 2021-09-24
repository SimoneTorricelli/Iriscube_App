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
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.view.get
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomsheet.BottomSheetDialog
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
        val movementAdapter = RecycleMovementAdapter { sampleData -> adapterOnClick(sampleData)}
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
        val dialog = context?.let { it1 -> BottomSheetDialog(it1) }

        // on below line we are inflating a layout file which we have created.
        val view = layoutInflater.inflate(R.layout.fragment_second, null)

        // on below line we are creating a variable for our button
        // which we are using to dismiss our dialog.
        val btnClose = view.findViewById<Button>(R.id.idBtnDismiss)

        val titleText : TextView= view.findViewById(R.id.movement_title2)
        val valueText : TextView= view.findViewById(R.id.movement_value2)
        val descriptionText : TextView= view.findViewById(R.id.movement_description2)

        titleText.text = "Titolo movimento: " + movement.title
        valueText.text = "Quantità movimento: " + movement.value.toString() + " €"
        descriptionText.text = "Descrizione movimento: " + movement.description



        // on below line we are adding on click listener
        // for our dismissing the dialog button.
        btnClose.setOnClickListener {
            // on below line we are calling a dismiss
            // method to close our dialog.
            dialog?.dismiss()
        }
        // below line is use to set cancelable to avoid
        // closing of dialog box when clicking on the screen.
        dialog?.setCancelable(false)

        // on below line we are setting
        // content view to our view.
        dialog?.setContentView(view)

        // on below line we are calling
        // a show method to display a dialog.
        dialog?.show()
        /*
        val intent = Intent(this, MovementDetailActivity()::class.java)
        intent.putExtra(MOVEMENT_ID, movement.id)
        startActivity(intent)
        */

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