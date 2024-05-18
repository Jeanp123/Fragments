package dev.jp.parcial

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LogInA : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_log_in)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val Userlog: EditText = findViewById(R.id.Userlog)
        val Passlog: EditText = findViewById(R.id.Passlog)
        val btnon: Button = findViewById(R.id.btnon)

        btnon.setOnClickListener {
            val usuario : String = Userlog.text.toString()
            val contraseña : String = Passlog.text.toString()
            if (usuario == "admin@smartapp.com" && contraseña == "admin123"){
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
            }

            Toast.makeText(this,
                "Credenciales invalidas"
                , Toast.LENGTH_LONG).show()
        }

    }
}