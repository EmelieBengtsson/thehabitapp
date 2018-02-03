package com.example.ola.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TextInputEditText
import android.widget.NumberPicker

class AddBookActivity : AppCompatActivity() {
   var numberPicker: NumberPicker? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_book)
        setupNumberPicker()
        setupTextInput()
    }

    private fun setupTextInput() {
        val textInputEditText = findViewById<TextInputEditText>(R.id.txtInBookTitle)

    }

    private fun setupNumberPicker (){
        numberPicker = findViewById<NumberPicker>(R.id.npBookScore) as NumberPicker
        numberPicker.minValue = 1
        numberPicker.maxValue = 4
        numberPicker.displayedValues = arrayOf("Bad", "OK", "Good", "Very Good")
    }

}
