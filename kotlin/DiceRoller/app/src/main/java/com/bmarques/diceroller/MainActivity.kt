package com.bmarques.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.lang.Integer.parseInt

class MainActivity : AppCompatActivity() {

    lateinit var diceImage : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        diceImage = findViewById(R.id.dice_image)

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }


//        val countUpButton: Button = findViewById(R.id.countup_button)
//        countUpButton.setOnClickListener { countUp() }

//        val resultText: TextView = findViewById(R.id.result_text)
//        resultText.text = "Dice Rolled!"

    }

//    private fun countUp() {
//        val resultText: TextView = findViewById(R.id.result_text)
//
//        val numeric = resultText.text.matches("-?\\d+(\\.\\d+)?".toRegex())
//
//        if (!numeric) return
//
//        val textInt = parseInt(resultText.text.toString())
//
//        if (textInt >= 6) return
//
//        resultText.text = (textInt + 1).toString()
//    }

    private fun rollDice() {
//        Toast.makeText(this, "button clicked",
//            Toast.LENGTH_SHORT).show()

        val drawableResource = when ((1..6).random()) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(drawableResource)

//        val resultText: TextView = findViewById(R.id.result_text)
//        resultText.text = randomInt.toString()
    }
}