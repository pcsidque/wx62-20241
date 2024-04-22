package com.example.appsem6_py1_sharedp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val sharedPreference = SharedPreferences(this)

        val btSave = findViewById<Button>(R.id.btSave)
        val etUser = findViewById<EditText>(R.id.etUser)
        val btGet = findViewById<Button>(R.id.btGet)
        val tvGetName = findViewById<TextView>(R.id.tvGetName)

        btSave.setOnClickListener {
            val user = etUser.text.toString()

            //grabar el usuario en el SP
            sharedPreference.save("user", user)

            Toast.makeText(this, "Usuario grabado!", Toast.LENGTH_LONG).show()
        }

        btGet.setOnClickListener {
            val name = sharedPreference.getValue("user")
            tvGetName.text = name
        }
    }
}