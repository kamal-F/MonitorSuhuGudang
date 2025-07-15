package com.example.monitorsuhugudang

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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btn = findViewById<Button>(R.id.btnStatus)
        val input = findViewById<EditText>(R.id.inputSuhu)
        val tv = findViewById<TextView>(R.id.textView)

        btn.setOnClickListener {
            val suhu = input.text.toString().toIntOrNull()
            if (suhu != null) {
                val status = if (suhu < 27) "Suhu Aman" else "Periksa Pendingin!"
                Toast.makeText(this, "Status: $status", Toast.LENGTH_SHORT).show()
                tv.text = "Suhu Gudang: ${suhu}°C"
            } else {
                Toast.makeText(this, "Masukkan suhu valid", Toast.LENGTH_SHORT).show()
            }
        }

    }
}