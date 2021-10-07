package com.popov.unitconverter

import android.os.Bundle
import android.text.Editable
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textViewLeft = findViewById<TextInputEditText>(R.id.editTextLeft)
        val textViewRight = findViewById<TextInputEditText>(R.id.editTextRight)

        textViewLeft.addTextChangedListener {
            if (textViewLeft.text.toString() != ""){
                val num = textViewLeft.text.toString().toDouble()
                val result = num * 0.13332239023
//                val resultOut: Double = String.format("%.2f", result).toDouble()
                textViewRight.text = Editable.Factory.getInstance().newEditable(result.toString())
            }
        }

        textViewRight.addTextChangedListener {
            if (textViewRight.text.toString() != ""){
                val num = textViewRight.text.toString().toDouble()
                val result = num * 7.5006156
                textViewLeft.text = Editable.Factory.getInstance().newEditable(result.toString())
            }
        }
    }
}