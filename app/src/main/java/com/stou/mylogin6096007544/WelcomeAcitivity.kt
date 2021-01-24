package com.stou.mylogin6096007544

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class WelcomeAcitivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_acitivity)
        supportActionBar!!.title = "Welcome "
        val textView: TextView = findViewById(R.id.txt_welcome)
        val text = intent.extras!!.getString("username")
        textView.text = "Welcome : $text"
    }
}