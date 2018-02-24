package com.example.ola.myapplication

import android.content.SharedPreferences
import android.os.Bundle
import android.support.design.widget.TextInputEditText
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import android.widget.NumberPicker
import android.widget.Toast
import com.google.gson.Gson

class AddBookActivity : AppCompatActivity() {
    val SHARED_PREF_KEY="habitappen"
    val SHARED_PREF_BOOKS="books"

    private lateinit var bookScorePicker: NumberPicker
    private lateinit var bookTitleInput: TextInputEditText
    private lateinit var submitBookButton: Button
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = this.getSharedPreferences(SHARED_PREF_KEY, android.content.Context.MODE_PRIVATE)
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
            } else {
                val bookToBeAdded = Book(bookTitleInput.text.toString(), bookScorePicker.value)
                val gson = Gson()
                val jsonBook = gson.toJson(bookToBeAdded)
                val editor = sharedPreferences.edit()
                editor.putString(bookToBeAdded.title, jsonBook)
                editor.apply()
                Toast.makeText(this , "Saved ${bookToBeAdded.title} with score ${bookToBeAdded.score}", Toast.LENGTH_LONG).show()
                setupTextInput()
                setupNumberPicker()
            }

        }
    }

    private fun setupTextInput() {
        bookTitleInput = findViewById<TextInputEditText>(R.id.txtInBookTitle) as TextInputEditText
        bookTitleInput.setText("")

    }

    private fun setupNumberPicker() {
        bookScorePicker = findViewById<NumberPicker>(R.id.npBookScore) as NumberPicker
        bookScorePicker.minValue = 1
        bookScorePicker.maxValue = 4
        bookScorePicker.displayedValues = arrayOf("Bad", "OK", "Good", "Very Good")
    }

}
