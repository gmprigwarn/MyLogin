package com.stou.mylogin6096007544

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ErrorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_error)
        supportActionBar!!.title = "Error "
    }
}