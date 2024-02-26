package br.com.haroldo.copodagua

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar

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

        refresh()

    }

    private fun saveGlass(glassType: GlassType) {
        preferences.save(today + glassType.value)

        Snackbar.make(findViewById(android.R.id.content), R.string.undo, Snackbar.LENGTH_LONG)
            .setAction(android.R.string.ok) {
                preferences.save(today - glassType.value)
                refresh()
            }
            .show()

        refresh()
    }

    private fun refresh() {
        val value = preferences.fetch()
        today = value
        findViewById<TextView>(R.id.txt_result).text = today.toString()
    }

}