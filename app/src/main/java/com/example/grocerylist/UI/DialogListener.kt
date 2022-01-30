package com.example.grocerylist.UI

import com.example.grocerylist.database.GroceryEntity

interface DialogListener {
    fun onAddButtonClicked(item:GroceryEntity)
}