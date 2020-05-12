package com.example.kotlinworkshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import androidx.fragment.app.FragmentStatePagerAdapter

class ReaderActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager
    private var content: List<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reader)

        viewPager = findViewById(R.id.slider)

        var lorem = resources.getString(R.string.lorem_ipsum)
        content = lorem.split(",", limit=3)

        val pagerAdapter = ReaderAdapter(supportFragmentManager, FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, content!!)
        viewPager.adapter = pagerAdapter
    }
}
