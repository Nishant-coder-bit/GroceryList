package com.example.grocerylist.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.grocerylist.R
import com.example.grocerylist.UI.GroceryViewModel
import com.example.grocerylist.database.GroceryEntity
import kotlinx.android.synthetic.main.grocery_adapter.view.*

class GroceryAdapter(var list: List<GroceryEntity> ,val viewModel:GroceryViewModel):RecyclerView.Adapter<GroceryAdapter.GroceryViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GroceryAdapter.GroceryViewHolder {
         val view = LayoutInflater.from(parent.context).inflate(R.layout.grocery_adapter,parent,false);
        return GroceryViewHolder(view)
    }

    override fun onBindViewHolder(holder: GroceryAdapter.GroceryViewHolder, position: Int) {
         var currpositon=list[position]
        holder.itemView.txtItemName.text=currpositon.itemName
        holder.itemView.txtItemPrice.text="${currpositon.itemPrice}"
        holder.itemView.txtItemQuantity.text="${currpositon.itemQuantity}"

        holder.itemView.ibDelete.setOnClickListener {
             viewModel.delete(currpositon)
        }
        if (position == list.size - 1) {
            var totalCost = 0
            for (i in 0 until list.size) {
                totalCost += list[i].itemPrice
            }
            holder.itemView.txtItemTotalCost.visibility = View.VISIBLE
            holder.itemView.txtTotalCostTitle.visibility = View.VISIBLE
            holder.itemView.txtItemTotalCost.text = "$totalCost"
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
  class GroceryViewHolder(itemView:View):RecyclerView.ViewHolder(itemView)
}