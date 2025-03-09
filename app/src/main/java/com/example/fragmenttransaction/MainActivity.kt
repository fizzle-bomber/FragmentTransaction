package com.example.fragmenttransaction

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        if(savedInstanceState == null){
          supportFragmentManager.beginTransaction()
              .add(R.id.left_container, LoginFragment())
              .commit()
        }

        supportFragmentManager.beginTransaction()
            .replace(R.id.right_container, DemoFragment())
            .commit()

    }
}