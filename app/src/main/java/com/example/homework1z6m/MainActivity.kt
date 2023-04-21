package com.example.homework1z6m

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var editText: EditText
    private lateinit var button: Button

    companion object {
        private const val REQUEST_CODE = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.edit_text)
        button = findViewById(R.id.button)

        button.setOnClickListener {
            val inputText = editText.text.toString().trim()
            if (inputText.isEmpty()) {
                Toast.makeText(this, "Edit Text не должен быть пустым", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, SecondScreen::class.java)
                intent.putExtra("inputText", inputText)
                startActivityForResult(intent, REQUEST_CODE)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val outputText = data?.getStringExtra("outputText")
            outputText?.let {
                editText.setText(it)
            }
        }
    }
}





