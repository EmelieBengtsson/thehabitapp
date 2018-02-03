package com.example.ola.myapplication

import android.os.Bundle
import android.support.design.widget.TextInputEditText
import android.support.v7.app.AppCompatActivity
import android.widget.NumberPicker

class AddBookActivity : AppCompatActivity() {
    private lateinit var numberPicker: NumberPicker
    private lateinit var textInputEditText: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_book)
        setupNumberPicker()
        setupTextInput()
    }

    private fun setupTextInput() {
        textInputEditText = findViewById<TextInputEditText>(R.id.txtInBookTitle) as TextInputEditText

    }

    private fun setupNumberPicker() {
        numberPicker = findViewById<NumberPicker>(R.id.npBookScore) as NumberPicker
        numberPicker.minValue = 1
        numberPicker.maxValue = 4
        numberPicker.displayedValues = arrayOf("Bad", "OK", "Good", "Very Good")
    }

}
