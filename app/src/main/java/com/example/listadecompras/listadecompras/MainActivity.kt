package com.example.listadecompras.listadecompras

import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.listadecompras.listadecompras.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), BillableItemAdapter.BillableItemListener {

    private lateinit var adapter:BillableItemAdapter

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main) as ActivityMainBinding
        adapter = BillableItemAdapter(ArrayList(),this)

        binding.recycler.adapter = adapter

        binding.btnInsert.setOnClickListener {
            val productsName = binding.txtProduct.text.toString()

            if (productsName.trim().isNotEmpty()){
                adapter.add(productsName)
                binding.txtProduct.text.clear()
            } else {
                binding.txtProduct.error = "Preencha um valor"
            }
        }

    }

    override fun onBillableItemLongClick(item: String, position: Int) {
       confirmDeleteItem(item, position)
    }

    private fun confirmDeleteItem(item: String, position: Int){
        val builder = AlertDialog.Builder(this)
        builder.apply {
            setMessage(getString(R.string.delete_billable_item_message,item))
            setPositiveButton(R.string.confirm){ dialog, _ ->
                adapter.removeItem(position)
                dialog.dismiss()
            }
            setNegativeButton(R.string.cancel){ dialog, _ ->
                dialog.dismiss()
            }
        }
        builder.create().show()
    }



}