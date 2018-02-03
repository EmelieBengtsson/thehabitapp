package com.example.ola.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val createBookButton = findViewById<Button>(R.id.btnCreateBook)
        createBookButton.setOnClickListener { view ->
            Log.i("Emelie","somebody clicked the button")
            val addBookIntent = Intent(this, AddBookActivity::class.java)
            startActivity(addBookIntent)
        }
    }
}
