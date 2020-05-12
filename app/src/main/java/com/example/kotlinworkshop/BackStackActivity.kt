package com.example.kotlinworkshop

import android.app.PendingIntent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.TaskStackBuilder

class BackStackActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_back_stack)
    }
}
