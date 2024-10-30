package com.example.recyclerviewandroidkotlin

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerViewForProducts : RecyclerView
    private lateinit var productAdapter: ProductAdapter
    private lateinit var products : ArrayList<Product>
    private  lateinit var users : ArrayList<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        initViews()
        initArrays()
        initAdapter()
    }

    private fun initViews() {
        recyclerViewForProducts = findViewById(R.id.recyclerViewForProducts)
    }
    private fun initArrays(){
        products = ArrayList<Product>()
        for (i in 0 .. 100){
            products.add(Product(i+5,"prduct" + i, + i *500.0))
        }
        users = ArrayList<User>()
            for (i in 0..100){
                users.add(User("Rohit" + i , "Pune" + i))
            }
    }


    private fun initAdapter(){
        productAdapter = ProductAdapter(products,users)
        recyclerViewForProducts.adapter = productAdapter
        recyclerViewForProducts.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

    }

}