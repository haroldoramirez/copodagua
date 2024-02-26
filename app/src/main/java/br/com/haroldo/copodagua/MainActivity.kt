package br.com.haroldo.copodagua

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    //Criando o objeto preferences para o conexto a aplicacao
    private val preferences = GlassPreferences(this)

    var today: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btn_small).setOnClickListener {
            saveGlass(GlassType.SMALL)
        }
        findViewById<Button>(R.id.btn_medium).setOnClickListener {
            saveGlass(GlassType.MEDIUM)
        }
        findViewById<Button>(R.id.btn_large).setOnClickListener {
            saveGlass(GlassType.LARGE)
        }

    }

    private fun saveGlass(glassType: GlassType) {
        preferences.save(today + glassType.value)
    }

}