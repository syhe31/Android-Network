package com.example.networktest

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment


class FragmentB : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        @Nullable container: ViewGroup?,
        @Nullable savedInstanceState: Bundle?
    ): View? {
//        val content : String? = arguments?.getString("content")
//
//        Toast.makeText(activity,content,Toast.LENGTH_SHORT).show();

        return inflater.inflate(R.layout.fragment_b, container, false)
    }

}