package com.example.a4_recyclerview_custom_adapter_loading_more_kotlin

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.a4_recyclerview_custom_adapter_loading_more_kotlin.adapter.CustomAdapter
import com.example.a4_recyclerview_custom_adapter_loading_more_kotlin.listener.onBottomReachedListener
import com.example.a4_recyclerview_custom_adapter_loading_more_kotlin.model.Member

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()

        val members = prepareMemberList()
        refreshAdapter(members)
    }
    private fun initViews() {
        val context : Context = this
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = GridLayoutManager(context,1)
    }

    private fun refreshAdapter(members: List<Member>) {
        val adapter = CustomAdapter(members, object:onBottomReachedListener{
            override fun onBottomReached(position: Int) {
                Toast.makeText(this@MainActivity,"This is $position - item",Toast.LENGTH_SHORT).show()
            }
        } )
        recyclerView.adapter = adapter

    }

     fun prepareMemberList(): List<Member> {
       val members = ArrayList<Member>()
        for(i in  0..29){
            if(i == 0 || i == 5 || i == 14 || i == 21){
                members.add(Member("Sarvarbek"+i,"Khalmatov"+i,false))
            }else{
                members.add(Member("Sarvarbek"+i,"Khalmatov"+i,true))

            }
        }
        return members
    }

}