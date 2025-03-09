package com.example.fragmenttransaction

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Switch
import android.widget.TextView

class FormFragment : Fragment() {

    private lateinit var inputField: EditText
    private lateinit var textView: TextView
    private lateinit var checkBox: CheckBox
    private lateinit var radioGroup: RadioGroup
    private lateinit var switchButton: Switch

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_form, container, false)

        // Bind views
        inputField = view.findViewById(R.id.inputField)
        textView = view.findViewById(R.id.textView)
        checkBox = view.findViewById(R.id.checkBox)
        radioGroup = view.findViewById(R.id.radioGroup)
        switchButton = view.findViewById(R.id.switchButton)

        // Set initial text for TextView (to test if it changes)
        textView.text = "Initial TextView Value"

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