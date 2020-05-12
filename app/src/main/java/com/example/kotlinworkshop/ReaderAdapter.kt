package com.example.kotlinworkshop

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter;


class ReaderAdapter(fragmentManager: FragmentManager, behavior: Int, var content: List<String>) : FragmentStatePagerAdapter(fragmentManager, behavior) {

    override fun getItem(position: Int): Fragment {
        return PageFragment(content[position])
    }

    override fun getCount(): Int {
        return 3
    }
}