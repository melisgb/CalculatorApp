package com.ggonzales.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun numberButtonClick(view: View) {
        var screenText = screenEditText.text.toString()
        val buttonSelected = view as Button

        if(isOperatorClicked == true){
            oldNumber = screenText
            screenText = ""
            isOperatorClicked = false
        }

        if(screenText == "0"){
            screenText = ""
        }
        when(buttonSelected.id){
            R.id.ceroButton ->  screenText += "0"
            R.id.oneButton ->   screenText += "1"
            R.id.twoButton ->   screenText += "2"
            R.id.threeButton -> screenText += "3"
            R.id.fourButton ->  screenText += "4"
            R.id.fiveButton ->  screenText += "5"
            R.id.sixButton ->   screenText += "6"
            R.id.sevenButton -> screenText += "7"
            R.id.eightButton -> screenText += "8"
            R.id.nineButton ->  screenText += "9"
            R.id.dotButton -> {
                if(screenText.contains(".")) return
                if(screenText == "") screenText += "0."
                else screenText += "."
            }
            R.id.signChangeButton ->  {
                if(screenText.substring(0,1)=="-") {
                    screenText = screenText.substring(1)

                }
                else screenText = "-" + screenText
            }
            R.id.percentButton ->  {
                screenText += "%"
            }
        }
        screenEditText.setText(screenText)

    }

    var oper = ""
    var oldNumber = ""
    var isOperatorClicked = false
    fun operatorButtonClick(view: View) {
        var screenText = screenEditText.text.toString()
        val buttonSelected = view as Button

        when(buttonSelected.id){
            R.id.sumButton -> {
                oper = "+"
            }
            R.id.minusButton -> {
                oper = "-"
            }
            R.id.multiplyButton -> {
                oper = "*"
            }
            R.id.divideButton -> {
                oper = "/"
            }
        }
        oldNumber = screenText
        isOperatorClicked = true
    }


    fun calculateResultClick(view : View){
        //  Behaviour Equal Button
        var newNumber = screenEditText.text.toString()
        var result = 0.0

        if(newNumber.contains("%") && newNumber[newNumber.length-1] != '%'){
            val percIdx = newNumber.indexOfFirst{ it == '%'}
            val numA = newNumber.substring(0,percIdx).toDouble()
            val numB = newNumber.substring(percIdx+1).toDouble()
            result = numA * (numB / 100)
        }

        else {
            if(newNumber[newNumber.length-1]=='%') {
                newNumber = (newNumber.substring(0, newNumber.length-1).toDouble() / 100).toString()
            }
            when (oper) {
                "+" -> result = oldNumber.toDouble() + newNumber.toDouble()
                "-" -> result = oldNumber.toDouble() - newNumber.toDouble()
                "*" -> result = oldNumber.toDouble() * newNumber.toDouble()
                "/" -> result = oldNumber.toDouble() / newNumber.toDouble()
            }
            result = String.format("%.2f", result).toDouble()
        }
            screenEditText.setText(result.toString())
    }

    fun resetText(view : View){
        var acButton = view as Button
        screenEditText.setText("")

    }
}
