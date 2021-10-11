package com.popov.unitconverter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.google.android.material.textfield.TextInputEditText
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textViewLeft = findViewById<TextInputEditText>(R.id.editTextLeft)
        val textViewRight = findViewById<TextInputEditText>(R.id.editTextRight)

        textViewLeft.addTextChangedListener {
            if (textViewLeft.text.toString() != ""){
                val num = textViewLeft.text.toString().toDouble()
                val result = decimalRound(num * 0.13332239023)
                if (textViewRight.text.toString() == ""){
                    textViewRight.setText(result.toString())
                }
            }else{
                textViewRight.text = null
            }
        }

        textViewRight.addTextChangedListener {
            if (textViewRight.text.toString() != ""){
                val num = textViewRight.text.toString().toDouble()
                val result = decimalRound(num * 7.5006156)
                if (textViewLeft.text.toString() == ""){
                    textViewLeft.setText(result.toString())
                }
            }else{
                textViewLeft.text = null
            }
        }
    }
    private fun decimalRound(number: Double): Double{
        var result = (number*10).roundToInt()
        val dd = number*10 - result
        if (dd >= 0.5){
            result += 1
        }
        return result/ 10.toDouble()
    }
}