package com.example.qoran.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.qoran.R
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        var name=intent.extras!!.getString("sura_name")
        var standard=intent.extras!!.getString("standard_full")
        textView.text=name
        textView2.text=standard

    }
}