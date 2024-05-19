package com.example.myapplication.task

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Patterns
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    lateinit var registerBinding: ActivityRegisterBinding
    private lateinit var genderSpinner: Spinner
    private lateinit var sharedPreferences: SharedPreferences



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        registerBinding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(registerBinding.root)

        genderSpinner = registerBinding.genderSpinner

        val genders = arrayOf("Male", "Female", "Other")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, genders)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        genderSpinner.adapter = adapter

        val defaultPosition = 0
        genderSpinner.setSelection(defaultPosition)

        registerBinding.signUpButton.setOnClickListener(){
            saveData()
            startActivity(Intent(this@RegisterActivity,LoginActivity::class.java))
    }



    }
    private fun saveData(){
        sharedPreferences = getSharedPreferences("userProfile", MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val fullName = registerBinding.fullNameRegister.text.toString()
        val email = registerBinding.emailRegister.text.toString()
        val address = registerBinding.addressRegister.text.toString()
        val password = registerBinding.passwordRegister.text.toString()
        val confirmPassword = registerBinding.confirmPasswordRegister.text.toString()
        val gender = genderSpinner.selectedItem.toString()


        if (fullName.isEmpty() || email.isEmpty() || address.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || gender == "Gender") {
            Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show()
            return
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(this, "Invalid email address", Toast.LENGTH_SHORT).show()
            return
        }

        if (password.length < 6) {
            Toast.makeText(this, "Password must be at least 6 characters long", Toast.LENGTH_SHORT).show()
            return
        }

        if (password != confirmPassword) {
            Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
            return
        }

        editor.putString("fullName", fullName)
        editor.putString("email", email)
        editor.putString("address", address)
        editor.putString("password", password)
        editor.putString("gender", gender)

        editor.apply()

        Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT).show()
    }

}