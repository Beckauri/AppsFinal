package com.example.afinal


import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class BMIActivity: AppCompatActivity() {

    private lateinit var resultTextView: TextView
    private lateinit var heigthInput: EditText
    private lateinit var weightInput: EditText
    private lateinit var calculatebutton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_b_m_i)


        heigthInput = findViewById(R.id.height)
        weightInput = findViewById(R.id.weight)
        calculatebutton = findViewById(R.id.calculatebutton)
        resultTextView = findViewById(R.id.result)


        calculatebutton.setOnClickListener {
            val height = heigthInput.text.toString().toFloat() /100
            val weight = weightInput.text.toString().toFloat()
            val res = weight/(height*height)
            resultTextView.text = "%.2f".format(res)
        }

    }
}