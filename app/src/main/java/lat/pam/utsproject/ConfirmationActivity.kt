package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ConfirmationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_confirmation)

        val foodName = intent.getStringExtra("foodName")
        val servings = intent.getStringExtra("servings")
        val orderingName = intent.getStringExtra("orderingName")
        val notes = intent.getStringExtra("notes")

        val confFood = findViewById<TextView>(R.id.conffood)
        confFood.text = "Food Name: $foodName"

        val confServings = findViewById<TextView>(R.id.confServ)
        confServings.text = "Number of Servings: $servings pax"

        val confOrdName = findViewById<TextView>(R.id.cusName)
        confOrdName.text = "Ordering name: $orderingName"

        val confNote = findViewById<TextView>(R.id.note)
        confNote.text = "Additional Notes: $notes"

        val btnToMenu: Button = findViewById(R.id.backtoMenu)
        btnToMenu.setOnClickListener{
            val moveMenu = Intent(this@ConfirmationActivity, ListFoodActivity::class.java)
            startActivity(moveMenu)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}