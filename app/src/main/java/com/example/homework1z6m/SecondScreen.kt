package com.example.homework1z6m

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class SecondScreen : AppCompatActivity() {
    private lateinit var editText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_screen)

        editText = findViewById(R.id.edit_text)
        val button2 = findViewById<Button>(R.id.button)
        button2.setOnClickListener {
            val outputText = editText.text.toString().trim()
            val intent = Intent()
            intent.putExtra("outputText", outputText)
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}
