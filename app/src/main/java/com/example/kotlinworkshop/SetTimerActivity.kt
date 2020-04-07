package com.example.kotlinworkshop

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class SetTimerActivity : AppCompatActivity() {

    private lateinit var button: Button
    private lateinit var input: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_timer)
        button = findViewById<Button>(R.id.button)
        input = findViewById<EditText>(R.id.input)
    }

    fun onClick(view: View) {
        val number = Integer.parseInt(input.text.toString())
        val intent = Intent()
        intent.putExtra("number", number)
        setResult(Activity.RESULT_OK, intent)
        finish()
    }
}
