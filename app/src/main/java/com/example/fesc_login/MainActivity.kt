package com.example.fesc_login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import java.io.File

class MainActivity : AppCompatActivity() {

    private val fileName = "user.txt"
    private val defaultUSer = "Carlos Mantilla;1093591378;1234"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val inputUsername = findViewById<EditText>(R.id.etUsername)
        val inputPassword = findViewById<EditText>(R.id.etPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        val file = File(filesDir, fileName)

        if (!file.exists()) {
            file.writeText(defaultUSer)
        }

        btnLogin.setOnClickListener {
            val username = inputUsername.text.toString()
            val password = inputPassword.text.toString()

            val userData = file.readText().split(";")

            val storeUsername = userData[1]
            val storePassword = userData[2]

            if (username == storeUsername && password == storePassword) {
                startActivity(Intent(this, ProfileActivity::class.java))
                finish()
            }

        }

    }
}