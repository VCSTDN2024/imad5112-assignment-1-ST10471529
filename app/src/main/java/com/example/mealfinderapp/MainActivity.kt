package com.example.mealfinderapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    private lateinit var timeText: EditText
    private lateinit var displayTimeText: TextView
    private lateinit var genMealBtn: Button
    private lateinit var menuBtn: Button
    private lateinit var resetBtn: Button
    private lateinit var exitBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        timeText = findViewById(R.id.timetext)
        displayTimeText = findViewById(R.id.displaytimetext)
        genMealBtn = findViewById(R.id.GenMealbtn)
        menuBtn = findViewById(R.id.menubtn)
        resetBtn = findViewById(R.id.resetbtn)
        exitBtn = findViewById(R.id.exitbtn)

        genMealBtn.setOnClickListener {
            generateMeal()
        }
        menuBtn.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
        exitBtn.setOnClickListener {
            moveTaskToBack(true)
            android.os.Process.killProcess(android.os.Process.myPid())
            exitProcess(1)
        }
        resetBtn.setOnClickListener {
            timeText.text.clear()
            displayTimeText.text = ""
        }
    }
    private fun generateMeal() {
        val time = timeText.text.toString()

        if (time.isEmpty()) {
            displayTimeText.text = "Please enter a time of day,morning etc."
            Toast.makeText(this, "Please enter a time of day, morning etc.", Toast.LENGTH_SHORT).show()
            return
        }
        val meal = when {
            time.contains("mid-morning", ignoreCase = true) -> "Yogurt and granola cereal"
            time.contains("morning", ignoreCase = true) -> "Bacon and eggs with toast and coffee"
            time.contains("mid-lunch", ignoreCase = true) -> "Toasted chicken mayo and egg sandwich"
            time.contains("lunch", ignoreCase = true) -> "Chicken Curry and Rice with vegetables with rice"
            time.contains("dinner", ignoreCase = true) -> "Roast Lamb,Backed potato and vegetables with rice"
            time.contains("dessert", ignoreCase = true) -> "Ice cream and sprinkles with chocolate sauce"
            else -> "Please validate the time as Morning etc."
        }
        displayTimeText.text = meal
    }
}






