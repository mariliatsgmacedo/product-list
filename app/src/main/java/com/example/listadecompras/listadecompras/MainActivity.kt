package com.example.listadecompras.listadecompras

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.listadecompras.listadecompras.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var adapter:BillableItemAdapter

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main) as ActivityMainBinding
        adapter = BillableItemAdapter(ArrayList())

        binding.recycler.adapter = adapter

        binding.btnInsert.setOnClickListener {
            val productsName = binding.txtProduct.text.toString()
            adapter.add(productsName)
        }

    }
}