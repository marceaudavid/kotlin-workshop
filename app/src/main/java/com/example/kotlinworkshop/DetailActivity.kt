package com.example.kotlinworkshop

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class DetailActivity : AppCompatActivity() {

    private var id: Int? = null
    private var title: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        id = intent.getIntExtra("id", 0)
        title = intent.getStringExtra("title")

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val fragment = DetailFragment()
        val bundle = Bundle()
        bundle.putInt("id", id!!)
        bundle.putString("title", title)
        fragment.arguments = bundle
        fragmentTransaction.add(R.id.detail_fragment, fragment, "fragment")
        fragmentTransaction.commit()
    }
}
