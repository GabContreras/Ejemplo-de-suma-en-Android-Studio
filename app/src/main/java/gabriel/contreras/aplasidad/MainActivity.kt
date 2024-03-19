package gabriel.contreras.aplasidad

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

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

        //1: Mandar a llamar a todos los elementos

        val numerinho1 = findViewById<EditText>(R.id.txtnum1)
        val numerinho2 = findViewById<EditText>(R.id.txtnum2)
        val botonSumar = findViewById<Button>(R.id.btnSumar)

        val txtResultado = findViewById<TextView>(R.id.txtResultado)

        //Creo un objeto de la clase calculadora para con ese objeto, llamar al método de sumar
        //Programarlos
        val objCalculadora= Calculadora()

        botonSumar.setOnClickListener {
       val result = objCalculadora.sumar(numerinho1.text.toString().toInt(),numerinho2.text.toString().toInt())
        Toast.makeText(this, "este es el resultado: $result",Toast.LENGTH_LONG).show()

            txtResultado.text= "El resultado es: $result"
        }
    }
}