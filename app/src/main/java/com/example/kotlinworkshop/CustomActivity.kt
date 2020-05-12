package com.example.kotlinworkshop

import android.graphics.Typeface
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide


class CustomActivity : AppCompatActivity() {

    private lateinit var image: ImageView
    private lateinit var text: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_custom)

        image = findViewById(R.id.custom_image)
        text = findViewById(R.id.custom_legend)

        Glide.with(this)
            .load(R.mipmap.ic_launcher)
            .centerCrop()
            .into(image);
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.custom_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_create -> {
                text.toggleVisibility()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun View.toggleVisibility() {
        if (visibility == View.VISIBLE) {
            visibility = View.INVISIBLE
        } else {
            visibility = View.VISIBLE
        }
    }
}
