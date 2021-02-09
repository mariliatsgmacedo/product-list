package com.example.listadecompras.listadecompras

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.listadecompras.listadecompras.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main) as ActivityMainBinding

        val productsAdapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1)
        binding.listView.adapter = productsAdapter
    }
}