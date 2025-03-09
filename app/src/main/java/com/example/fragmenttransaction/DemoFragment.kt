package com.example.fragmenttransaction

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class DemoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_demo, container, false)

        // Add Fragment
        view.findViewById<Button>(R.id.addButton).setOnClickListener {
            parentFragmentManager.beginTransaction()
                .add(R.id.demo_container, ColorFragment(Color.RED))
                .addToBackStack(null)
                .commit()
        }

        // Replace Fragment
        view.findViewById<Button>(R.id.replaceButton).setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.demo_container, ColorFragment(Color.BLUE))
                .addToBackStack(null)
                .commit()
        }

        // Hide Fragment
        view.findViewById<Button>(R.id.hideButton).setOnClickListener {
            val currentFragment = parentFragmentManager.findFragmentById(R.id.demo_container)
            if (currentFragment != null) {
                parentFragmentManager.beginTransaction()
                    .hide(currentFragment)
                    .commit()
            }
        }

        return view
    }
}