package com.popov.unitconverter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.popov.unitconverter.constants.Constants
import com.popov.unitconverter.databinding.ActivityMainBinding
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.translateButton.setOnClickListener {
            if (binding.editTextLeft.isFocused && binding.editTextLeft.text.toString() != "") {
                val num = binding.editTextLeft.text.toString().toDouble()
                val result = decimalRound(num * Constants.MMHG_CONST)
                binding.editTextRight.setText(result.toString())
            }

            if (binding.editTextRight.isFocused && binding.editTextRight.text.toString() != "") {
                val num = binding.editTextRight.text.toString().toDouble()
                val result = decimalRound(num * Constants.PA_CONST)
                binding.editTextLeft.setText(result.toString())
            }
        }

        binding.editTextLeft.addTextChangedListener {
            if (binding.editTextLeft.isFocused && binding.editTextLeft.text.toString() == "") {
                binding.editTextRight.setText("")
            }
        }

        binding.editTextRight.addTextChangedListener {
            if (binding.editTextRight.isFocused && binding.editTextRight.text.toString() == "") {
                binding.editTextLeft.setText("")
            }
        }
    }
    private fun decimalRound(number: Double): Double{
        var result = (number*10).roundToInt()
        val dd = number*10 - result
        if (dd >= 0.5){
            result += 1
        }
        return result/ 10.0
    }
}