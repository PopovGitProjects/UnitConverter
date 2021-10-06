package com.popov.unitconverter

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textViewLeft = findViewById<TextInputEditText>(R.id.editTextLeft)
        val textViewRight = findViewById<TextInputEditText>(R.id.editTextRight)
        val tvOutLeft = findViewById<TextView>(R.id.textLeft)
        val tvOutRight = findViewById<TextView>(R.id.textRight)

        textViewLeft.addTextChangedListener {
            if (textViewLeft.text.toString() != ""){
                val num = textViewLeft.text.toString().toDouble()
                val result = num * 0.13332239023
                tvOutLeft.text = result.toString().format("%.2lf", result)
            }else {
                tvOutLeft.text = "0"
            }
        }

        textViewRight.addTextChangedListener {
            if (textViewRight.text.toString() != ""){
                val num = textViewRight.text.toString().toDouble()
                val result = num * 7.5006156
                tvOutRight.text = result.toString().format("%.2f")
            }else {
                tvOutRight.text = "0"
            }
        }
    }
}