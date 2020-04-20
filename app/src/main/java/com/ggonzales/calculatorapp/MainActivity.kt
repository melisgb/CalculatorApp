package com.ggonzales.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun numberButtonClick(view: View) {
        val buttonSelected = view as Button
        if(resultsEditText.text.toString() == "0"){
            resultsEditText.text.clear()
        }
        if(buttonSelected.text == "."){
            if(resultsEditText.text.contains(".")) return
        }
        resultsEditText.text.append(buttonSelected.text.toString())




    }
}
