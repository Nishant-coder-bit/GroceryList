package com.example.grocerylist.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface GroceryDao{

     @Insert
     suspend fun insert(item:GroceryEntity)

     @Delete
     suspend fun delete(item: GroceryEntity)

     @Query("Select * from groceryEntity")
       fun getAllGroceryItems():LiveData<List<GroceryEntity>>
}