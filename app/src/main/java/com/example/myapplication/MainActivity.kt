package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var toast: Toast? = null
    private var rollButton: Button? = null;
    private var resultText: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultText = findViewById(R.id.result_text)
        rollButton = findViewById(R.id.roll_button)
        rollButton?.setOnClickListener { rollDice() }
    }

    private fun rollDice() {
        changeResultText()
        showToast()
    }

    private fun changeResultText() {
        resultText?.text = (1..6).random().toString()
    }

    private fun showToast() {
        toast?.cancel()
        toast = Toast.makeText(this, "Sort by toggled", Toast.LENGTH_SHORT)
        toast?.show()
    }
}