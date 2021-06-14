package ru.geekbrains.androidkotlinhomeworksapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var spinnerCountries: Spinner? = null
    var capitalView: TextView? = null
    private var noteView: TextView? = null
    private var allCapitalsView: TextView? = null
    var noteText: String? = ""
    private var noteInf = NoteDataClass(null, null)
    var buttonAllCapitals: Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        spinnerCountries = findViewById(R.id.spinnerCountries)
        capitalView = findViewById(R.id.textViewCapital)
        allCapitalsView = findViewById(R.id.textViewForAllCapitals)
        buttonAllCapitals = findViewById(R.id.buttonAllCapitals)
        noteView = findViewById(R.id.textViewNote)

    }

    fun showCapital(view: View?) {
        val position = spinnerCountries!!.selectedItemPosition
        val capital = getCapitalByPosition(position)
        capitalView!!.text = capital
    }

    private fun getCapitalByPosition(position: Int): String {
        val capitals = resources.getStringArray(R.array.capitals)
        val country = resources.getStringArray(R.array.countries)
        noteInf.noteRecordCountry = country[position]
        return capitals[position]
    }

    fun recordCapital(view: View) {
        val noteInfCopy: NoteDataClass = noteInf.copy()
        noteInfCopy.noteRecordCapital = capitalView?.getText() as String?
        noteText =
            noteText + " " + noteInfCopy.noteRecordCountry + " - " + noteInfCopy.noteRecordCapital + "\n"
        noteView!!.text = noteText
    }

    fun printAllCapitals(view: View) {
        val capitals = resources.getStringArray(R.array.capitals)
        allCapitalsView?.let { allCapitalsToView(capitals, it) }
    }


    fun allCapitalsToView(arr: Array<String>, textView: TextView) {
        var temporVar: String = ""
        for (i in arr) {
            temporVar = temporVar + " " + i
        }
        textView.text = temporVar
    }

}


