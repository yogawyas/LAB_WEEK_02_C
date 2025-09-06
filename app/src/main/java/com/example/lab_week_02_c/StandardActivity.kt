package com.example.lab_week_02_c

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class StandardActivity : AppCompatActivity() {
    companion object {
        private const val DEBUG = "DEBUG"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_standard)
        Log.d(DEBUG, "onCreate")

        // Tombol untuk membuka StandardActivity baru setiap kali ditekan
        findViewById<Button>(R.id.button_standard).setOnClickListener {
            startActivity(
                Intent(this, StandardActivity::class.java)
            )
        }

        // Atur padding supaya tidak ketutupan system bar
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        Log.d(DEBUG, "onNewIntent")
    }
}
