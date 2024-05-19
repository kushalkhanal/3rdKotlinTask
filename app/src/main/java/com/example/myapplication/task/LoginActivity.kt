package com.example.myapplication.task

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    lateinit var loginBinding: ActivityLoginBinding
    private lateinit var sharedPreferences:SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(loginBinding.root)

        loginBinding.createAccountButton.setOnClickListener(){

            startActivity(Intent(this@LoginActivity,RegisterActivity::class.java))

        }
        loginBinding.loginButton.setOnClickListener(){
            if(isValidUser(loginBinding.emailLogin.text.toString(),loginBinding.passwordLogin.text.toString())){
                Toast.makeText(this,"Login Successful",Toast.LENGTH_SHORT).show()

                startActivity(Intent(this@LoginActivity,DashboardActivity::class.java))
                finish()
            }
            else{
                Toast.makeText(this,"Invalid Credentials",Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun isValidUser(email:String , password: String):Boolean{
        sharedPreferences = getSharedPreferences("userProfile", MODE_PRIVATE)
        val storedEmail = sharedPreferences.getString("email","")
        val storedPassword = sharedPreferences.getString("password","")

        return email==storedEmail && password == storedPassword

    }
}