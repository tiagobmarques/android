package com.bmarques.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.lang.Integer.parseInt

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }

        val countUpButton: Button = findViewById(R.id.countup_button)
        countUpButton.setOnClickListener { countUp() }

        val resultText: TextView = findViewById(R.id.result_text)
        resultText.text = "Dice Rolled!"

    }

    private fun countUp() {
        val resultText: TextView = findViewById(R.id.result_text)

        val numeric = resultText.text.matches("-?\\d+(\\.\\d+)?".toRegex())

        if (!numeric) return

        val textInt = parseInt(resultText.text.toString())

        if (textInt >= 6) return

        resultText.text = (textInt + 1).toString()
    }

    private fun rollDice() {
//        Toast.makeText(this, "button clicked",
//            Toast.LENGTH_SHORT).show()
        val randomInt = (1..6).random()

        val resultText: TextView = findViewById(R.id.result_text)
        resultText.text = randomInt.toString()
    }
}