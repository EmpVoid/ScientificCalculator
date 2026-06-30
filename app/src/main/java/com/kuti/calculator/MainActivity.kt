package com.kuti.calculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var tvDisplay: TextView

    private var currentInput = ""
    private var firstNumber = 0.0
    private var operator = ""
    private var resultDisplayed = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvDisplay = findViewById(R.id.tvDisplay)

        val numberIds = listOf(
            R.id.btn0,R.id.btn1,R.id.btn2,R.id.btn3,R.id.btn4,
            R.id.btn5,R.id.btn6,R.id.btn7,R.id.btn8,R.id.btn9
        )

        numberIds.forEach { id ->
            findViewById<Button>(id).setOnClickListener {
                appendNumber((it as Button).text.toString())
            }
        }

        findViewById<Button>(R.id.btnDot).setOnClickListener {
            appendNumber(".")
        }

        findViewById<Button>(R.id.btnDelete).setOnClickListener {
            if (currentInput.isNotEmpty()) {
                currentInput = currentInput.dropLast(1)
                tvDisplay.text = currentInput
            }
        }

        findViewById<Button>(R.id.btnC).setOnClickListener {
            currentInput = ""
            operator = ""
            firstNumber = 0.0
            tvDisplay.text = "0"
        }

        setupOperator(R.id.btnPlus, "+")
        setupOperator(R.id.btnMinus, "-")
        setupOperator(R.id.btnMultiply, "*")
        setupOperator(R.id.btnDivide, "/")

        findViewById<Button>(R.id.btnEqual).setOnClickListener {

            val secondNumber = currentInput.toDouble()

            val result = when(operator) {
                "+" -> firstNumber + secondNumber
                "-" -> firstNumber - secondNumber
                "*" -> firstNumber * secondNumber
                "/" -> firstNumber / secondNumber
                else -> 0.0
            }

            tvDisplay.text = result.toString()
            currentInput = result.toString()
            resultDisplayed = true
        }

        findViewById<Button>(R.id.btnScientific).setOnClickListener {
            startActivity(
                Intent(this, ScientificActivity::class.java)
            )
        }
    }

    private fun appendNumber(value: String) {

        if(resultDisplayed){
            currentInput = ""
            resultDisplayed = false
        }

        currentInput += value
        tvDisplay.text = currentInput
    }

    private fun setupOperator(id:Int, op:String){

        findViewById<Button>(id).setOnClickListener {

            firstNumber = currentInput.toDouble()
            operator = op
            currentInput = ""
        }
    }
}