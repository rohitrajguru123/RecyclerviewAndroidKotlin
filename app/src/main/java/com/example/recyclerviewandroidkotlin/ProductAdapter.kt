package com.example.recyclerviewandroidkotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter(private val products: List<Product>, private val users: List<User>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val VIEW_PRODUCT = 1
    private val VIEW_USER = 2

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val img: ImageView = itemView.findViewById(R.id.img)
        private val name: TextView = itemView.findViewById(R.id.nameTV)
        private val price: TextView = itemView.findViewById(R.id.price)

        fun bind(product: Product) {
            img.setImageResource(R.drawable.ic_launcher_background) // Replace with product image
            name.text = product.name
            price.text = "${product.price}"
        }
    }

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imgUser: ImageView = itemView.findViewById(R.id.imgUser)
        private val userName: TextView = itemView.findViewById(R.id.userName)
        private val userCity: TextView = itemView.findViewById(R.id.userCity)

        fun bind(user: User) {
            imgUser.setImageResource(R.drawable.ic_launcher_background) // Replace with user image
            userName.text = user.userName
            userCity.text = user.userCity
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (position % 2 == 0) VIEW_PRODUCT else VIEW_USER
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return if (viewType == VIEW_PRODUCT) {
            val productView = layoutInflater.inflate(R.layout.product_viewholder, parent, false)
            ProductViewHolder(productView)
        } else {
            val userView = layoutInflater.inflate(R.layout.userviewholder, parent, false)
            UserViewHolder(userView)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ProductViewHolder) {
            val product = products[position / 2] // Adjust index for products
            holder.bind(product)
        } else if (holder is UserViewHolder) {
            val user = users[(position - 1) / 2] // Adjust index for users
            holder.bind(user)
        }
    }

    override fun getItemCount(): Int {
        return products.size + users.size // Total count of items
    }
}
