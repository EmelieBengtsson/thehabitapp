package com.example.ola.myapplication

import android.os.Bundle
import android.support.design.widget.TextInputEditText
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.NumberPicker
import android.widget.Toast

class AddBookActivity : AppCompatActivity() {
    private lateinit var bookScorePicker: NumberPicker
    private lateinit var bookTitleInput: TextInputEditText
    private lateinit var submitBookButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_book)
        setupNumberPicker()
        setupTextInput()
        setupButton()
    }

    private fun setupButton(){
        submitBookButton = findViewById<Button>(R.id.btnSubmitBook) as Button
        submitBookButton.setOnClickListener{ view ->
            if(bookTitleInput.text.isBlank()){
                Toast.makeText(this , "Ajabaja", Toast.LENGTH_SHORT).show()
            }
            Book(bookTitleInput.text.toString(), bookScorePicker.value)
        }
    }

    private fun setupTextInput() {
        bookTitleInput = findViewById<TextInputEditText>(R.id.txtInBookTitle) as TextInputEditText

    }

    private fun setupNumberPicker() {
        bookScorePicker = findViewById<NumberPicker>(R.id.npBookScore) as NumberPicker
        bookScorePicker.minValue = 1
        bookScorePicker.maxValue = 4
        bookScorePicker.displayedValues = arrayOf("Bad", "OK", "Good", "Very Good")
    }

}
