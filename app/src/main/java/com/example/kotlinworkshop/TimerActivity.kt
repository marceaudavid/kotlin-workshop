package com.example.kotlinworkshop

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


@Suppress("DEPRECATED_IDENTITY_EQUALS")
class TimerActivity : AppCompatActivity() {

    private lateinit var text: TextView
    private var number: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer)
        text = findViewById<TextView>(R.id.text)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode === 200 && resultCode === Activity.RESULT_OK) {
            number = data?.getIntExtra("number", 100)
            launchTimer(number)
        }
    }

    fun onClick(view: View) {
        val intent = Intent(this, SetTimerActivity::class.java)
        startActivityForResult(intent, 200)
    }

    private fun launchTimer(number: Int?) {
        object : CountDownTimer(number?.toLong()!!, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                text.text = (millisUntilFinished/1000).toString()
            }

            override fun onFinish() {
                text.text = "Create a Timer"
            }
        }.start()
    }


}
