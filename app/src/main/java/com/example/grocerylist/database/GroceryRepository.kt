package com.example.grocerylist.database

class GroceryRepository(private val db:GroceryDatabase) {
    suspend fun insert(item:GroceryEntity)=db.getGroceryDao().insert(item)
    suspend fun delete(item:GroceryEntity)=db.getGroceryDao().delete(item)

    fun allGroceryItems()=db.getGroceryDao().getAllGroceryItems()
}