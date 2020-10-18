package com.yml.cardkotlin

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

lateinit var button1: Button
lateinit var button2: Button
lateinit var clearText: Button
lateinit var update: Button
lateinit var back: Button
lateinit var e1: EditText
lateinit var e2: EditText
lateinit var e3: EditText
lateinit var e4: EditText
lateinit var t1: TextView
lateinit var t2: TextView
lateinit var t3: TextView

class MainActivity : AppCompatActivity() {

    var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        supportActionBar!!.hide()
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_main)
        button1 = findViewById(R.id.noti)
        button1.setOnClickListener{
            Toast.makeText(applicationContext, "Pressed the notification button", Toast.LENGTH_SHORT).show() }
        button2 = findViewById(R.id.update)
        e2 = findViewById(R.id.edit2)
        e3 = findViewById(R.id.edit3)
        e4 = findViewById(R.id.edit4)
        e1 = findViewById(R.id.edit1)
        t1 = findViewById(R.id.code)
        t2 = findViewById(R.id.cardholdername)
        t3 = findViewById(R.id.expdate1)
        clearText = findViewById(R.id.clearTextBtn)
        clearText.setOnClickListener{
            e1.setText("") }
        button2.setOnClickListener{
            val cardNumber = e1.getText().toString()
            val name = e2.getText().toString()
            val date = e3.getText().toString()
            val cvv = e4.getText().toString()
            if (TextUtils.isEmpty(cardNumber) || TextUtils.isEmpty(name) || TextUtils.isEmpty(date) || TextUtils.isEmpty(cvv)) {
                Toast.makeText(applicationContext, "Enter all the fields", Toast.LENGTH_SHORT).show()
            } else {
                t1.setText(cardNumber)
                t2.setText(name)
                t3.setText(date)
            }
        }
        back = findViewById(R.id.back)
        back.setOnClickListener{ finish() }
        e1.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) { /*Empty*/
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int,
                                       count: Int) { /*Empty*/
            }

            @SuppressLint("SetTextI18n")
            override fun afterTextChanged(s: Editable) {
                val inputlength = e1.getText().toString().length
                if (count <= inputlength && inputlength == 4 || inputlength == 9 || inputlength == 14) {
                    e1.setText(e1.getText().toString() + " ")
                    val pos = e1.getText().length
                    e1.setSelection(pos)
                }
                count = e1.getText().toString().length
            }
        })
        e3.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) { /*Empty*/
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int,
                                       count: Int) { /*Empty*/
            }

            @SuppressLint("SetTextI18n")
            override fun afterTextChanged(s: Editable) {
                val inputlength = e3.getText().toString().length
                if (count <= inputlength && inputlength == 2) {
                    e3.setText(e3.getText().toString() + "/")
                    val pos = e3.getText().length
                    e3.setSelection(pos)
                }
                count = e3.getText().toString().length
            }
        })
    }
}