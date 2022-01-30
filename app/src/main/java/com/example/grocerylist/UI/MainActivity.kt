package com.example.grocerylist.UI

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.grocerylist.Adapter.GroceryAdapter
import com.example.grocerylist.R
import com.example.grocerylist.database.GroceryDatabase
import com.example.grocerylist.database.GroceryEntity
import com.example.grocerylist.database.GroceryRepository
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var viewModel:GroceryViewModel
    lateinit var list:List<GroceryEntity>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val groceryRepository=GroceryRepository(GroceryDatabase(this))
        val factory=GroceryViewModelFactory(groceryRepository)

        viewModel = ViewModelProvider(this, factory).get(GroceryViewModel::class.java)
        val groceryAdapter = GroceryAdapter(listOf(), viewModel)
        rvList.layoutManager = LinearLayoutManager(this)
        rvList.adapter = groceryAdapter

         viewModel.allGroceryItems().observe(this, Observer {
             groceryAdapter.list=it
             groceryAdapter.notifyDataSetChanged()
         })
        btnAdd.setOnClickListener {
            GroceryItemDialog(this, object : DialogListener {
                override fun onAddButtonClicked(item: GroceryEntity) {
                    viewModel.insert(item)
                }
            }).show()
        }
    }
}