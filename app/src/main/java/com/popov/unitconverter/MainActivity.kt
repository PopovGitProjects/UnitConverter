package com.popov.unitconverter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import com.popov.unitconverter.calculations.PressureCalculation
import com.popov.unitconverter.constants.Constants
import com.popov.unitconverter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            translateButton.setOnClickListener{
                if (!editTextLeft.text.isNullOrEmpty() && editTextLeft.isFocused){
                    editTextRight.setText(PressureCalculation()
                        .calculatePressure(editTextLeft, Constants.MMHG_CONST))
                }
                if (!editTextRight.text.isNullOrEmpty() && editTextRight.isFocused){
                    editTextLeft.setText(PressureCalculation()
                        .calculatePressure(editTextRight, Constants.PA_CONST))
                }
            }
            editTextLeft.addTextChangedListener {
                if (editTextLeft.text.isNullOrEmpty() && editTextLeft.isFocused){
                    editTextRight.setText("")
                }
            }
            editTextRight.addTextChangedListener {
                if (editTextRight.text.isNullOrEmpty() && editTextRight.isFocused){
                    editTextLeft.setText("")
                }
            }
        }
    }
}