package com.example.qoran.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

import com.example.qoran.R


class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        supportActionBar?.hide()

        Handler().postDelayed({
            var intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        },2500)

    }
}