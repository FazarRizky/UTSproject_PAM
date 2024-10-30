package lat.pam.utsproject

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)

        val idReg: EditText = findViewById(R.id.regId)
        val pasReg: EditText = findViewById(R.id.regPass)
        val btnreg: Button = findViewById(R.id.btSubmRegis)

        btnreg.setOnClickListener{
            val id = idReg.text.toString()
            val pass = pasReg.text.toString()

            if (id.isNotEmpty() && pass.isNotEmpty()){
                val sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
                val editor = sharedPreferences.edit()
                editor.putString("Id",id)
                editor.putString("Password",pass)
                editor.apply()

                Toast.makeText(this, "Register Done Bang !!", Toast.LENGTH_SHORT).show()

                val move_intent = Intent(this@Register, MainActivity::class.java)
                startActivity(move_intent)
                finish()
            }
            else{
                Toast.makeText(this, "Isi dulu datanya bosss !!", Toast.LENGTH_SHORT).show()
            }
        }




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}