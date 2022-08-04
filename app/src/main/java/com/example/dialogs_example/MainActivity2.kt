package com.example.dialogs_example

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.FragmentActivity

class MainActivity2 : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            Toast.makeText(this, "button", Toast.LENGTH_SHORT).show()
        }
    }
}
