package com.example.fesc_login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import java.io.File

class ProfileActivity : AppCompatActivity() {

    private val fileName = "user.txt"
    private lateinit var tvName: TextView
    private lateinit var tvUsername: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profile)

        tvName = findViewById(R.id.tvName)
        tvUsername = findViewById(R.id.tvUsername)

        loadUserData()

        findViewById<Button>(R.id.btnEdit).setOnClickListener {
            startActivity(Intent(this, EditNameActivity::class.java))
        }

        findViewById<Button>(R.id.btnChangePassword).setOnClickListener {
            startActivity(Intent(this, EditPasswordActivity::class.java))
        }

        findViewById<Button>(R.id.btnExit).setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

    }

    override fun onResume() {
        super.onResume()
        loadUserData()
    }

    private fun loadUserData() {

        val file = File(filesDir, fileName)
        val userData = file.readText().split(";")


        tvName.text = "Nombre: ${userData[0]}"
        tvUsername.text = "Cédula: ${userData[1]}"
    }

}