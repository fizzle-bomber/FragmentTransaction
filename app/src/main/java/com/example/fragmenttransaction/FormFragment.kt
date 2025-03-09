package com.example.fragmenttransaction

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText

class FormFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_form, container, false)

        val inputField = view.findViewById<EditText>(R.id.inputField)

        view.findViewById<Button>(R.id.openListButton).setOnClickListener {
            // Add ListFragment on top
            parentFragmentManager.beginTransaction()
                .setCustomAnimations(
            R.anim.slide_in_right, // Enter animation
            R.anim.slide_out_left, // Exit animation
            R.anim.slide_in_left,  // Pop enter animation
            R.anim.slide_out_right  // Pop exit animation
        )
                //.hide(this@FormFragment)
                .replace(R.id.fragment_container, ListFragment())
                .addToBackStack(null)
                .commit()
        }

        view.findViewById<Button>(R.id.submitButton).setOnClickListener {
            // Replace with SuccessFragment
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, SuccessFragment())
                .addToBackStack(null)
                .commit()
        }

        parentFragmentManager.setFragmentResultListener("request_key", viewLifecycleOwner) { _, bundle
        ->
            val selectedItem = bundle.getString("selectedItem")
            inputField.setText(selectedItem)
        }
        return view

    }
}