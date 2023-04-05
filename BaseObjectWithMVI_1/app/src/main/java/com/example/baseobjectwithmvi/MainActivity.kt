package com.example.baseobjectwithmvi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : BaseActivity() {

    override val getContentView: Int = R.layout.activity_main

    override fun init(savedInstanceState: Bundle?) {
        setTitle("1234")
    }

}