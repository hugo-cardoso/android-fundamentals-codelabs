package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var toast: Toast? = null
    private var diceNumber: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        roll_button.setOnClickListener { rollDice() }
    }

    private fun rollDice() {
        updateDiceNumber()
        showToast()
    }

    private fun updateDiceNumber() {
        diceNumber = (1..6).random();
        updateDiceImage()
    }

    private fun updateDiceImage() {
        val diceResource = when (diceNumber) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.empty_dice
        }
        dice_image.setImageResource(diceResource);
    }

    private fun showToast() {
        toast?.cancel()
        toast = Toast.makeText(this, "Rolled!", Toast.LENGTH_SHORT)
        toast?.show()
    }
}