package lat.pam.utsproject

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var idReg: EditText
    private lateinit var pasReg: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        idReg = findViewById(R.id.etUsername)
        pasReg = findViewById(R.id.etPassword)


        val loginBtn: Button = findViewById(R.id.btnLogin)
        loginBtn.setOnClickListener(this)

        val regisBtn: Button = findViewById(R.id.tvRegister)
        regisBtn.setOnClickListener(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.btnLogin ->{
                val idlog = idReg.text.toString()
                val paslog = pasReg.text.toString()

                val sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
                val getId = sharedPreferences.getString("Id",null)
                val getPas = sharedPreferences.getString("Password",null)

                if (idlog == getId && paslog == getPas){
                    Toast.makeText(this, "welkam welkam!", Toast.LENGTH_SHORT).show()
                    val move_sistem = Intent(this@MainActivity, ListFoodActivity::class.java)
                    startActivity(move_sistem)
                }
            }

            R.id.tvRegister ->{
                val move_regis = Intent(this@MainActivity, Register::class.java)
                startActivity(move_regis)
            }
        }
    }
}