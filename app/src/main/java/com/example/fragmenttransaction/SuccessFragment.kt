package com.example.fragmenttransaction

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class SuccessFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_success, container, false)
        view.findViewById<Button>(R.id.backButton).setOnClickListener {
            // Replace with LoginFragment
            parentFragmentManager.beginTransaction()
                .replace(R.id.left_container, LoginFragment())
                .commit()
        }

        return view
    }

}