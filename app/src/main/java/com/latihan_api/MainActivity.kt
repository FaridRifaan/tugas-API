package com.latihan_api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.latihan_api.databinding.ActivityMainBinding
import com.latihan_api.model.TvTopRated
import com.latihan_api.networking.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

import com.latihan_api.model.Result

class MainActivity : AppCompatActivity() {

    val listTv = mutableListOf<Result>()
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        getTv()

    }
    fun getTv(){
        RetrofitClient.instance.getTvTopRated(
            APIKEY = "7d8d14c59d48644acd9d52f2409a2dab", PAGE = 1)
            .enqueue(object : Callback<TvTopRated<Result>>{
                override fun onResponse(call: Call<TvTopRated<Result>>,
                                        response: Response<TvTopRated<Result>>) {
                    if (response.isSuccessful){
                        binding.rvCon.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
                        val tvResponse = response.body()
                        if(tvResponse != null){
                            listTv.addAll(tvResponse.results)
                            binding.rvCon.adapter = TvAdapter(listTv)
                        }
                    }else{
                        Toast.makeText(this@MainActivity, "Failed LOAD DATA", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<TvTopRated<Result>>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "Failed LOAD DATA", Toast.LENGTH_SHORT).show()
                }

            })
    }

}