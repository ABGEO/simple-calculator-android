package dev.abgeo.simplecalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

const val EXTRA_NUMBER_1 = "dev.abgeo.simplecalculator.NUMBER_1"
const val EXTRA_NUMBER_2 = "dev.abgeo.simplecalculator.NUMBER_2"
const val EXTRA_ACTION = "dev.abgeo.simplecalculator.ACTION"

class MainActivity : AppCompatActivity() {
    private lateinit var etNumber1: EditText
    private lateinit var etNumber2: EditText
    private lateinit var btnActionPlus: Button
    private lateinit var btnActionMinus: Button
    private lateinit var btnActionMultiply: Button
    private lateinit var btnActionDivide: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        initListeners()
    }

    private fun initViews() {
        etNumber1 = findViewById(R.id.etNumber1)
        etNumber2 = findViewById(R.id.etNumber2)
        btnActionPlus = findViewById(R.id.btnActionPlus)
        btnActionMinus = findViewById(R.id.btnActionMinus)
        btnActionMultiply = findViewById(R.id.btnActionMultiply)
        btnActionDivide = findViewById(R.id.btnActionDivide)
    }

    private fun initListeners() {
        btnActionPlus.setOnClickListener { callAction('+') }
        btnActionMinus.setOnClickListener { callAction('-') }
        btnActionMultiply.setOnClickListener { callAction('*') }
        btnActionDivide.setOnClickListener { callAction('/') }
    }

    private fun callAction(action: Char) {
        val number1 = etNumber1.text.toString()
        val number2 = etNumber2.text.toString()

        if (number1.isEmpty() || number2.isEmpty()) {
            Toast.makeText(applicationContext, "Please enter both numbers", Toast.LENGTH_SHORT)
                .show()
            return
        }

        Intent(this, ResultActivity::class.java).apply {
            putExtra(EXTRA_NUMBER_1, number1.toFloat())
            putExtra(EXTRA_NUMBER_2, number2.toFloat())
            putExtra(EXTRA_ACTION, action)

            startActivity(this)
        }
    }
}