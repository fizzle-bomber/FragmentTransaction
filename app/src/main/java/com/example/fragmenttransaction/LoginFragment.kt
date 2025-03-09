package com.example.fragmenttransaction

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_login, container, false)

        view.findViewById<Button>(R.id.loginButton).setOnClickListener {
            //Replace with Form Fragment
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container,FormFragment())
                .addToBackStack(null)
                .commit()
        }

        view.findViewById<Button>(R.id.registerButton).setOnClickListener {
            // Replace with FormFragment
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, FormFragment())
                .addToBackStack(null)
                .commit()
        }

        return view
    }
}