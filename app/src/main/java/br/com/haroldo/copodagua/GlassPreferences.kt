package br.com.haroldo.copodagua

import android.content.Context
import androidx.core.content.edit
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class GlassPreferences(private val context: Context) {

    private val formatoData = SimpleDateFormat("ddMMyyyy", Locale.US)

    companion object {
        const val PREFS_NAME = "br.com.haroldo.copodagua"
        const val PREFS_PREFIX = "key_"
    }

    fun save(value: Int) {
        //Abrindo uma conexao de dados preferences com o NAME e a chave que eu salvar e PREFS_PREFIX e a data de hoje
        context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
            .edit {
                putInt(PREFS_PREFIX + formatoData.format(Date()), value)
            }
    }

    fun fetch(): Int {
        return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
            .getInt(PREFS_PREFIX + formatoData.format(Date()), 0)
    }

}