package com.example.grocerylist.database

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class GroceryEntity(
    val itemName:String,
    val itemQuantity:Int,
    val itemPrice:Int,

    @PrimaryKey(autoGenerate = true)
     var id:Int?=null
)