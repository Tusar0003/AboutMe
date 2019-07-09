package com.example.aboutme

import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.example.aboutme.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val myName : MyName = MyName("Faisal Ahmed")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)

        /**
         * Binding object is like a layer of glue between the layout and it's views and it's data
         */
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myName = myName

//        findViewById<Button>(R.id.button_done).setOnClickListener {
//            addNickName(it)
//        }
        binding.buttonDone.setOnClickListener {
            addNickName(it)
        }
    }

    private fun addNickName(view: View) {
//        val nameEditText = findViewById<EditText>(R.id.edit_text_name)
//        val nameTextView = findViewById<TextView>(R.id.text_view_name)
//        val doneButton = findViewById<Button>(R.id.button_done)

        /**
         * binding.apply is used to make our code easier to read
         */
        binding.apply {
//            binding.textViewName.text = binding.editTextName.text
            myName?.nickname = edit_text_name.text.toString()

            /**
             * In order to refresh the ui with new data, invalidate is used.
             * So that they get recreated with new data
             */
            invalidateAll()
            binding.textViewName.visibility = View.VISIBLE
            binding.editTextName.visibility = View.GONE
            view.visibility = View.GONE
        }

        val imn = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imn.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
