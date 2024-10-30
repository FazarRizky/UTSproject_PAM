package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class OrderActivity : AppCompatActivity(), View.OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_order)

        val food_name = intent.getStringExtra("foodName")
        val food_desc = intent.getStringExtra("foodDescription")
        val food_img = intent.getIntExtra("foodImage", 0)

        val nameView: TextView = findViewById(R.id.etFoodName)
        val descView: TextView = findViewById(R.id.descFood)
        val imgView: ImageView = findViewById(R.id.imgOrder)

        nameView.text = food_name
        descView.text = food_desc
        imgView.setImageResource(food_img)

       val move_confrm: Button = findViewById(R.id.btnOrder)
        move_confrm.setOnClickListener(this)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnOrder -> {

                val foodName = findViewById<TextView>(R.id.etFoodName).text.toString()
                val servings = findViewById<EditText>(R.id.etServings).text.toString()
                val orderingName = findViewById<EditText>(R.id.etName).text.toString()
                val notes = findViewById<EditText>(R.id.etNotes).text.toString()


                // Intent ke ConfirmationActivity
                val intent = Intent(this, ConfirmationActivity::class.java)
                intent.putExtra("foodName", foodName)
                intent.putExtra("servings", servings)
                intent.putExtra("orderingName", orderingName)
                intent.putExtra("notes", notes)

                startActivity(intent)
            }
        }
    }


}