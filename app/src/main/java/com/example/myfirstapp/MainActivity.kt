package com.example.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.Toast
import com.example.myfirstapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding // important
    private val words = ArrayList<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)

        binding.buttonSaveWord.setOnClickListener {
            val word = binding.editTextName.text.trim().toString()
            if (word == "") {
                binding.editTextName.error = "No name"
                return@setOnClickListener
            }
            if (words.contains(word))
            {
                Toast.makeText(this, "$word already exists in the list!", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            words.add(word)
            Toast.makeText(this, "$word has been added to the list", Toast.LENGTH_LONG).show()
            binding.editTextName.setText("")
        }

        binding.buttonClearWords.setOnClickListener {
            if (words.isEmpty()) {
                Toast.makeText(this, "List is empty!", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            words.clear()
            binding.textViewMessage.text = "$words"
            Toast.makeText(this, "List has been cleared!", Toast.LENGTH_LONG).show()
        }

        binding.buttonShowWords.setOnClickListener {
            if (words.isEmpty()) {
                Toast.makeText(this, "The list is empty!", Toast.LENGTH_LONG).show()
            }
            binding.textViewMessage.text = "$words"
        }


    }
}