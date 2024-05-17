package com.jeezzzz.apitut

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class MainActivity : AppCompatActivity() {
    private lateinit var baseURL:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        baseURL="https://dummyjson.com/"

        val retrofitBuilder=Retrofit.Builder()
            .baseUrl(baseURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)

        val retrofitData=retrofitBuilder.getUserData()

        retrofitData.enqueue(object : Callback<MyUser?> {
            override fun onResponse(p0: Call<MyUser?>, p1: Response<MyUser?>) {
                val responseBody=p1.body()
                val userList= responseBody?.users!!

                var myAdapter=MyAdapter(this@MainActivity, userList)
                val recyclerView=findViewById<RecyclerView>(R.id.recyclerView)
                recyclerView.adapter=myAdapter
                recyclerView.layoutManager=LinearLayoutManager(this@MainActivity)


            }

            override fun onFailure(p0: Call<MyUser?>, p1: Throwable) {
                TODO("Not yet implemented")
            }
        })





    }
}
//        val retrofitBuilder= Retrofit.Builder()
//            .baseUrl("https://dummyjson.com/")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//            .create(ApiInterface::class.java)
//
//        val retrofitData=retrofitBuilder.getUserData()
//
//        retrofitData.enqueue(object : Callback<MyUser?> {
//            override fun onResponse(call: Call<MyUser?>, response: Response<MyUser?>) {
//                var responseBody=response.body()
//                val userList= responseBody?.users!!
//
//                val collectDataInStringBuilder=StringBuilder()
//
//                for(i in userList){
//                    collectDataInStringBuilder.append(user.firstName+" "+user.lastName)
//                }
//
//                var textView=findViewById<TextView>(R.id.textView)
//                textView.text=collectDataInStringBuilder
//            }
//
//
//            override fun onFailure(call: Call<MyUser?>, t: Throwable) {
//                Log.e("MainActivity", "onFailure:${t.message}")
//            }
//        })
//
//    }
//}