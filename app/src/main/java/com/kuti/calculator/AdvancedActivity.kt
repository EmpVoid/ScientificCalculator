package com.kuti.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.log10
import kotlin.math.sqrt

class ScientificActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_advanced)

        val etInput = findViewById<EditText>(R.id.etInput)
        val tvResult = findViewById<TextView>(R.id.tvResult)

        findViewById<Button>(R.id.btnSin).setOnClickListener {
            val angle = etInput.text.toString().toDoubleOrNull()
            if (angle == null) {
                tvResult.text = "Invalid input"
                return@setOnClickListener
            }
            val result =
                kotlin.math.sin(Math.toRadians(angle))
            tvResult.text = result.toString()
        }

        findViewById<Button>(R.id.btnCos).setOnClickListener {
            val angle = etInput.text.toString().toDoubleOrNull()
            if (angle == null) {
                tvResult.text = "Invalid input"
                return@setOnClickListener
            }
            val result =
                kotlin.math.cos(Math.toRadians(angle))
            tvResult.text = result.toString()
        }

        findViewById<Button>(R.id.btnTan).setOnClickListener {
            val angle = etInput.text.toString().toDoubleOrNull()
            if (angle == null) {
                tvResult.text = "Invalid input"
                return@setOnClickListener
            }
            val result =
                kotlin.math.tan(Math.toRadians(angle))
            tvResult.text = result.toString()
        }

        findViewById<Button>(R.id.btnLog).setOnClickListener {
            val number = etInput.text.toString().toDoubleOrNull()
            if (number == null) {
                tvResult.text = "Invalid input"
                return@setOnClickListener
            }
            tvResult.text =
                log10(number).toString()
        }

        findViewById<Button>(R.id.btnSqrt).setOnClickListener {
            val number = etInput.text.toString().toDoubleOrNull()
            if (number == null) {
                tvResult.text = "Invalid input"
                return@setOnClickListener
            }
            tvResult.text =
                sqrt(number).toString()
        }

        findViewById<Button>(R.id.btnSquare).setOnClickListener {
            val number = etInput.text.toString().toDoubleOrNull()
            if (number == null) {
                tvResult.text = "Invalid input"
                return@setOnClickListener
            }
            tvResult.text =
                (number * number).toString()
        }

        findViewById<Button>(R.id.btnPercent).setOnClickListener {

            val input = etInput.text.toString()

            val parts = input.split("%")

            if(parts.size == 2){

                val a = parts[0].toDouble()
                val b = parts[1].toDouble()
                if (a == null || b == null){
                    tvResult.text = "Invalid input"
                    return@setOnClickListener
                }

                val result = (a / 100) * b

                tvResult.text = result.toString()
            }
        }
        findViewById<Button>(R.id.btnExit).setOnClickListener {
            finish()
        }
    }
}