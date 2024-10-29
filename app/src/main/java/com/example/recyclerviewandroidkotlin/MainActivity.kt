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
    }
    private fun initAdapter(){
        productAdapter = ProductAdapter(products)
        recyclerViewForProducts.adapter = productAdapter
        recyclerViewForProducts.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

    }

}