package com.example.recyclerviewandroidkotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter(var products: ArrayList<Product>):
    RecyclerView.Adapter<ProductAdapter.ProductViewAdapter>() {


    class ProductViewAdapter(itemView : View) : RecyclerView.ViewHolder(itemView){
        private var img : ImageView
        private  var name : TextView
        private  var price : TextView
        init {
            img = itemView.findViewById(R.id.img)
            name = itemView.findViewById(R.id.nameTV)
            price = itemView.findViewById(R.id.price)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewAdapter {
        var layoutInflater : LayoutInflater = LayoutInflater.from(parent.context)
        var productView  = layoutInflater.inflate(R.layout.product_viewholder,null)
        return ProductViewAdapter(productView)
    }

    override fun onBindViewHolder(holder: ProductViewAdapter, position: Int) {
        var product = products[position]
        holder.itemView.findViewById<ImageView>(R.id.img).setImageResource(R.drawable.ic_launcher_background)
        holder.itemView.findViewById<TextView>(R.id.nameTV).text = product.name
        holder.itemView.findViewById<TextView>(R.id.price).text = "${product.price}"

    }
    override fun getItemCount(): Int {
        return products.size
    }

}