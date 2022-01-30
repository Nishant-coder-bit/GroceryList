package com.example.grocerylist.UI

import android.content.Context
import android.os.Bundle
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.grocerylist.R
import com.example.grocerylist.database.GroceryEntity
import kotlinx.android.synthetic.main.grocery_dialog.*

class GroceryItemDialog(context:Context,var dialogListener: DialogListener):AppCompatDialog(context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.grocery_dialog)

        tvSave.setOnClickListener {
            val name=etItemName.text.toString()
            val price=etItemPrice.text.toString().toInt()
            val quantity=etItemQuantity.text.toString().toInt()

             if(name.isEmpty()){
                 Toast.makeText(context,"pls enter item name",Toast.LENGTH_SHORT).show()
             }
            val item =GroceryEntity(name,quantity,price)
            dialogListener.onAddButtonClicked(item)
            dismiss()
        }
        tvCancel.setOnClickListener {
            cancel()
        }
    }

}