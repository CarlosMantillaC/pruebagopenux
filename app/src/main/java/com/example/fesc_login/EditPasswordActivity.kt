package com.example.fesc_login

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.File

class EditPasswordActivity : AppCompatActivity() {

    private val fileName = "user.txt"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_edit_password)

        val file = File(filesDir, fileName)
        val userData = file.readText().split(";")

        val inputPassword = findViewById<EditText>(R.id.etNewPassword)
        val btnSave = findViewById<Button>(R.id.btnSave)
        val btnBack = findViewById<Button>(R.id.btnBack)

        inputPassword.setText(userData[2])

        btnSave.setOnClickListener {

            val newPassword = inputPassword.text.toString()

            val updater = "${userData[0]};${userData[1]};$newPassword"

            file.writeText(updater)

        }

        btnBack.setOnClickListener {

            startActivity(Intent(this, ProfileActivity::class.java))
            finish()
        }


    }
}