package dev.abgeo.simplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val actionMapping: Map<Char, (Float, Float) -> Float> = mapOf(
            '+' to ::actionPlus,
            '-' to ::actionMinus,
            '*' to ::actionMultiply,
            '/' to ::actionDivide,
        )
        val action = intent.getCharExtra(EXTRA_ACTION, '+')
        val number1 = intent.getFloatExtra(EXTRA_NUMBER_1, 0f)
        val number2 = intent.getFloatExtra(EXTRA_NUMBER_2, 0f)
        val result = actionMapping[action]?.invoke(number1, number2)

        findViewById<TextView>(R.id.tvResult).text =
            getString(R.string.result, number1, action, number2, result)
    }

    private fun actionPlus(a: Float, b: Float): Float = a + b
    private fun actionMinus(a: Float, b: Float): Float = a - b
    private fun actionMultiply(a: Float, b: Float): Float = a * b
    private fun actionDivide(a: Float, b: Float): Float = a / b
}