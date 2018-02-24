package com.example.ola.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ListView
import android.content.SharedPreferences
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    val SHARED_PREF_KEY="habitappen"
    private lateinit var listFinishedBooks: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addBookButton = findViewById<Button>(R.id.btnAddBook)
        addBookButton.setOnClickListener { view ->
            Log.i("Emelie","somebody clicked the button")
            val addBookIntent = Intent(this, AddBookActivity::class.java)
            startActivity(addBookIntent)
        }
    }

    override fun onResume() {
        super.onResume()
        setupListFinishedBooks()
    }

    private fun setupListFinishedBooks() {
        listFinishedBooks = findViewById<ListView>(R.id.listFinishedBooks)
        val sharedPreferences = this.getSharedPreferences(SHARED_PREF_KEY, android.content.Context.MODE_PRIVATE)
        val bookJsons  = sharedPreferences.all.values.toList() as List<String>

         val presentationBooks = bookJsons.map{bookJson: String ->
            val book=Gson().fromJson(bookJson, Book::class.java)
             "${book.title} : ${book.score}"
        }.toList()

        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, presentationBooks)
        listFinishedBooks.adapter =adapter
    }


}
