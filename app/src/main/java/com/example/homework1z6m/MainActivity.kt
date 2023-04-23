import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult
import androidx.appcompat.app.AppCompatActivity
import com.example.homework1z6m.R
import com.example.homework1z6m.SecondScreen

class MainActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    private val startForResult = registerForActivityResult(StartActivityForResult()) { result: ActivityResult ->
        if (result.resultCode == RESULT_OK) {
            val outputText = result.data?.getStringExtra("outputText")
            editText.setText(outputText)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.edit_text)
        val button1 = findViewById<Button>(R.id.button)
        button1.setOnClickListener {
            val inputText = editText.text.toString().trim()
            if (inputText.isEmpty()) {
                Toast.makeText(this, "EditText не может быть пустым", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, SecondScreen::class.java)
                intent.putExtra("inputText", inputText)
                startForResult.launch(intent)
            }
        }
    }
}






