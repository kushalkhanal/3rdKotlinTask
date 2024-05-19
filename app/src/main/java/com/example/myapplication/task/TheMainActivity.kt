package com.example.myapplication.task

import android.content.Intent
import android.os.Bundle
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.R
import android.os.Handler

class TheMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_the_main)
        Handler(Looper.getMainLooper()).postDelayed({
            var intent = Intent(this@TheMainActivity,LoginActivity::class.java)
            startActivity(intent)
            finish()
        },3000)

    }
}