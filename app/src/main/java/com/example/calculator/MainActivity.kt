package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var selectedOperation = ""
    var oldNumber = ""
    var isNewOperation = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


fun clickButtonEvent(view: View) {
    if (isNewOperation) {
        clearNumber()
    }
    isNewOperation = false
    val selectNumber = view as Button
    val currentNumber: String = result.text.toString()
    val newNumber: String = setNextNumber(currentNumber, selectNumber)
    result.text = newNumber
    previewEvent(result.text.toString())
}

fun clearNumber() {
    result.text = "0"
    preview.text = ""
}

fun setNextNumber(oldNumber: String, selectButton: Button): String {
    var number: String = oldNumber
    when (selectButton.id) {
        btn_zero.id -> {
            if (number == "0" || number.isNullOrEmpty()) number = "0"
            else number += 0
        }
        btn_one.id -> {
            if (number == "0" || number.isNullOrEmpty()) number = "1"
            else number += 1
        }
        btn_two.id -> {
            if (number == "0" || number.isNullOrEmpty()) number = "2"
            else number += 2
        }
        btn_three.id -> {
            if (number == "0" || number.isNullOrEmpty()) number = "3"
            else number += 3
        }
        btn_four.id -> {
            if (number == "0" || number.isNullOrEmpty()) number = "4"
            else number += 4
        }
        btn_five.id -> {
            if (number == "0" || number.isNullOrEmpty()) number = "5"
            else number += 5
        }
        btn_six.id -> {
            if (number == "0" || number.isNullOrEmpty()) number = "6"
            else number += 6
        }
        btn_seven.id -> {
            if (number == "0" || number.isNullOrEmpty()) number = "7"
            else number += 7
        }
        btn_eight.id -> {
            if (number == "0" || number.isNullOrEmpty()) number = "8"
            else number += 8
        }
        btn_nine.id -> {
            if (number == "0" || number.isNullOrEmpty()) number = "9"
            else number += 9
        }
        btn_point.id -> {
            // TODO: 7/23/2020 prevent user to add more than point
            if (number == "") number = "0."
            else {
                if (number.indexOf('.') == -1) number += "."
            }
        }
        btn_sing.id -> {
            if (number == "0" || number.isNullOrEmpty()) number = "0"
            else {
                if (number.first() == '-') number = number.substring(1, number.lastIndex + 1)
                else number = "-$number"
            }
        }
    }
    previewEvent(result.text.toString())
    return number

}

fun operationEvent(view: View) {
    val selectionOperation = view as Button
    when (selectionOperation.id) {
        btn_division.id -> selectedOperation = "÷"
        btn_multiply.id -> selectedOperation = "×"
        btn_min.id -> selectedOperation = "-"
        btn_sum.id -> selectedOperation = "+"
    }
    isNewOperation = true
    previewEvent(selectionOperation.text.toString())
    oldNumber = result.text.toString()
}

fun equalsEvent(view: View) {
    view as Button
    val newNumber = result.text.toString().toDouble()
    var answer: Double? = null
    if (selectedOperation != "" && oldNumber != "") {
        when (selectedOperation) {
            "÷" -> answer = oldNumber.toDouble() / newNumber
            "×" -> answer = oldNumber.toDouble() * newNumber
            "-" -> answer = oldNumber.toDouble() - newNumber
            "+" -> answer = oldNumber.toDouble() + newNumber
        }
        result.text = answer.toString()
        previewEvent(result.text.toString())
        isNewOperation = true
        oldNumber = ""
        selectedOperation = ""
    }
}

fun percentageEvent(view: View) {
    view as Button
    result.text = (result.text.toString().toDouble() / 100).toString()
    previewEvent(result.text.toString())

}

fun clearInput(view: View) {
    view as Button
    clearNumber()
    isNewOperation = true
    result.text = "0"
    preview.text = ""
}

fun previewEvent(res: String) {
    preview.text = res
}
}