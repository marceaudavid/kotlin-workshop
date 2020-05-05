package com.example.kotlinworkshop

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment


class DetailFragment : Fragment() {

    private var id: Int? = null
    private var title: String? = null
    private lateinit var text: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
//        if (outState != null) {
//            id = outState.getInt("id");
//            title = outState.getgetString("id");
//        } else {
            id = arguments!!.getInt("id")
            title = arguments!!.getString("title")
//        }
        text = view?.findViewById<TextView>(R.id.detail_text)!!
        text.text = title
    }


//    override fun onSaveInstanceState(outState: Bundle?) {
//        state.putInt("id", id);
//        state.putString("title", title);
//        super.onSaveInstanceState(outState);
//    }
}