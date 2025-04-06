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

class EditNameActivity : AppCompatActivity() {

    private val fileName = "user.txt"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_edit_name)

        val file = File(filesDir, fileName)
        val userData = file.readText().split(";")

        val inputName = findViewById<EditText>(R.id.etNewName)
        val inputUsername = findViewById<EditText>(R.id.etNewUsername)
        val btnSave = findViewById<Button>(R.id.btnSave)
        val btnBack = findViewById<Button>(R.id.btnBack)

        inputName.setText(userData[0])
        inputUsername.setText(userData[1])

        btnSave.setOnClickListener {

            val newName = inputName.text.toString()
            val newUsername = inputUsername.text.toString()

            val updater = "$newName;$newUsername;${userData[2]}"

            file.writeText(updater)

        }

        btnBack.setOnClickListener {

            startActivity(Intent(this, ProfileActivity::class.java))
            finish()
        }


    }
}