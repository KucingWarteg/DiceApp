package com.example.diceapp

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollBtn: Button = findViewById(R.id.btnRoll)


        rollBtn.setOnClickListener { rollDice() }
        rollDice()
    }
        private fun rollDice() {
            val dice = Dice(6)
            val rollResult = dice.roll()

            val ivDice: ImageView = findViewById(R.id.ivDice)
            val imageResource = when (rollResult) {
                1 -> R.drawable._1_dice
                2 -> R.drawable._2_dice
                3 -> R.drawable._3_dice
                4 -> R.drawable._4_dice
                5 -> R.drawable._5_dice
                else -> R.drawable._6_dice
            }

            ivDice.setImageResource(imageResource)

            if (rollResult == 5) {
                val toast = Toast.makeText(this, "Anda Beruntung!", Toast.LENGTH_SHORT)
                toast.show()
            } else {
            val toast = Toast.makeText(this, "Coba Lagi!", Toast.LENGTH_SHORT)
            toast.show()
        }

    }
}

class Dice (private val sides: Int) {
    fun roll(): Int {
        return (1..sides).random()
    }
}
