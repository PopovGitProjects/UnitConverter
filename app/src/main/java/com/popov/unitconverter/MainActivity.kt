package com.popov.unitconverter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.popov.unitconverter.databinding.ActivityMainBinding
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.editTextLeft.addTextChangedListener {
            if (binding.editTextLeft.text.toString() != ""){
                val num = binding.editTextLeft.text.toString().toDouble()
                val result = decimalRound(num * 0.13332239023)
                binding.editTextRight.setText(result.toString())
            }else{
                binding.editTextRight.text = null
            }
        }

        binding.editTextRight.addTextChangedListener {
            if (binding.editTextRight.text.toString() != ""){
                val num = binding.editTextRight.text.toString().toDouble()
                val result = decimalRound(num * 7.5006156)
                binding.editTextLeft.setText(result.toString())
            }else{
                binding.editTextLeft.text = null
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