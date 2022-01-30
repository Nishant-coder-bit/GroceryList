package com.example.grocerylist.UI

import androidx.lifecycle.ViewModel
import com.example.grocerylist.database.GroceryEntity
import com.example.grocerylist.database.GroceryRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class GroceryViewModel(private val repository:GroceryRepository): ViewModel() {

     fun insert(item:GroceryEntity)=GlobalScope.launch {
         repository.insert(item)
     }

     fun delete(item:GroceryEntity)=GlobalScope.launch {
         repository.delete(item)
     }
    fun allGroceryItems()=repository.allGroceryItems()
}