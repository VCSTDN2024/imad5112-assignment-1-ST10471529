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

//C:\Users\Leander Hughes\AndroidStudioProjects\HistoryApp\app\src\main\java\com\example\historyapp\MainActivity.kt ( i used my previous app as guidance on designing my app, e.g the buttons variables)
class MainActivity : AppCompatActivity() {

    // Declaring the variables for the ids from buttons and text view.
    // https://developer.android. com/ kotlin/ common- patterns (used as guidance to help me understand how to use lateinit variables)
    private lateinit var timeText: EditText
    private lateinit var displayTimeText: TextView
    private lateinit var genMealBtn: Button
    private lateinit var menuBtn: Button
    private lateinit var resetBtn: Button
    private lateinit var exitBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // This sets the layout interface for this activity_main.xml
        setContentView(R.layout.activity_main)

        // Initializing the variables allowing the app to find the correct ids for use in the app.
        timeText = findViewById(R.id.timetext)
        displayTimeText = findViewById(R.id.displaytimetext)
        genMealBtn = findViewById(R.id.GenMealbtn)
        menuBtn = findViewById(R.id.menubtn)
        resetBtn = findViewById(R.id.resetbtn)
        exitBtn = findViewById(R.id.exitbtn)

        // Buttons that have set on click listeners to function correctly in the app.
        genMealBtn.setOnClickListener {
            generateMeal()
        }
        // Intent to allow the user to navigate to the menu activity_main2.
        menuBtn.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
        exitBtn.setOnClickListener {
            moveTaskToBack(true)
            // Simply just kills the process of the app completely allowing the user to exit the app.
            android.os.Process.killProcess(android.os.Process.myPid())
            exitProcess(1)
        }
        // Reset button to clear the text fields and display text allowing the user to enter new inputs.
        resetBtn.setOnClickListener {
            timeText.text.clear()
            displayTimeText.text = ""
        }
    }
    private fun generateMeal() {
        // This gets the input from the user and stores it in a variable.
        val time = timeText.text.toString()

        if (time.isEmpty()) {
            displayTimeText.text = "Please enter a time of day,morning etc."
            // Toast message to inform the user to enter a time of day,being specific as morning,lunch etc.
            Toast.makeText(this, "Please enter a time of day, morning etc.", Toast.LENGTH_SHORT).show()
            return
        }
        // I used a when statement to check the input and provide the correct output as it is easier for the application im running.
        val meal = when {
            // Checking the input to see if it matches the correct time of day. This allows the user to see the outcome of their input.
            // The word time in these codes refers to the string variable time i created in the generateMeal function above.
            // IgnoreCase = true (means im telling the app to compare the input ignoring the case sensitivity and provide the correct output given to that variable being "morning, mid-morning, etc)".
            // https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.text/contains.html (used as guidance on how incorporate my own time.contains function)
            time.contains("mid-morning", ignoreCase = true) -> "Yogurt and granola cereal"
            time.contains("morning", ignoreCase = true) -> "Bacon and eggs with toast and coffee"
            time.contains("mid-lunch", ignoreCase = true) -> "Toasted chicken mayo and egg sandwich"
            time.contains("lunch", ignoreCase = true) -> "Chicken Curry and Rice with vegetables with rice"
            time.contains("dinner", ignoreCase = true) -> "Roast Lamb,Backed potato and vegetables with rice"
            time.contains("dessert", ignoreCase = true) -> "Ice cream and sprinkles with chocolate sauce"
            // If the input does not match any of the times, it will display a message asking the user to enter a valid time of day.
            else -> "Please validate the time as Morning etc."
        }
        // This simply displays the meal based on the input made by the user.
        displayTimeText.text = meal
    }
}






