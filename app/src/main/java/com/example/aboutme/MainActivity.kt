package com.example.aboutme

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputBinding
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

//    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        findViewById<Button>(R.id.button_done).setOnClickListener {
            addNickName(it)
        }
    }

    private fun addNickName(view: View) {
        val nameEditText = findViewById<EditText>(R.id.edit_text_name)
        val nameTextView = findViewById<TextView>(R.id.text_view_name)
//        val doneButton = findViewById<Button>(R.id.button_done)

        nameTextView.text = nameEditText.text
        nameEditText.visibility = View.GONE
        view.visibility = View.GONE

        val imn = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imn.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
