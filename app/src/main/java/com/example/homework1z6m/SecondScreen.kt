package com.example.homework1z6m

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class SecondScreen : AppCompatActivity() {
    private lateinit var editText: EditText
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_screen)

        editText = findViewById(R.id.edit_text)
        button = findViewById(R.id.button)

        val inputText = intent.getStringExtra("inputText")
        inputText?.let {
            editText.setText(it)
        }

        button.setOnClickListener {
            val outputText = editText.text.toString().trim()

            val intent = Intent()
            intent.putExtra("outputText", outputText)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}