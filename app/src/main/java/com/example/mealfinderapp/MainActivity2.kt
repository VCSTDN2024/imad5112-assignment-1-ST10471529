package com.example.mealfinderapp

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity2 : AppCompatActivity() {
    private lateinit var backBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Changed the activity_,main to activity_main2 to display the correct layout for this activity.and allows the app to work
        setContentView(R.layout.activity_main2)

        // Declared the back button variable
        backBtn = findViewById(R.id.backbtn)

        // Allows the user to click the button which returns you to the first page of the app
        backBtn.setOnClickListener {
            finish()
        }
    }
}