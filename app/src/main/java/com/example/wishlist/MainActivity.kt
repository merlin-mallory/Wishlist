package com.example.wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText
import com.example.wishlist.Item as Item1

class MainActivity : AppCompatActivity() {
    lateinit var my_list: ArrayList<Item1>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val itemsRv = findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = ItemAdapter(my_list)
        itemsRv.adapter = adapter
        itemsRv.layoutManager = LinearLayoutManager(this)

        val item_name = findViewById<TextView>(R.id.input_name)
        val item_price = findViewById<TextView>(R.id.input_price)
        val item_store = findViewById<TextView>(R.id.input_site)
        val submit_button = findViewById<Button>(R.id.input_button)

        val name = item_name.text.toString()
        val url = item_store.text.toString()
        val price = item_price.editableText.toString()

        val item_to_add = Item1(name, price, url)
//        item_to_add.name = name
//        item_to_add.store = url
//        item_to_add.price = price

        submit_button.setOnClickListener {
            my_list.add(item_to_add)
        }
    }
}