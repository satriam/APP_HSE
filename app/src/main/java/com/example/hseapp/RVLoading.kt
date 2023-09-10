package com.example.hseapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hseapp.adapter.AdapterLoading
import com.example.hseapp.dao.DBHelper
import com.example.hseapp.retrofit.RetrofitInstance
import com.google.android.material.floatingactionbutton.FloatingActionButton

class RVLoading : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: AdapterLoading
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rvloading)
        sendSQLiteDataToApi()

        val actionbutton = findViewById<FloatingActionButton>(R.id.fab)

        actionbutton.setOnClickListener{
            val intent = Intent(this, LoadingActivity::class.java)
            startActivity(intent)
        }

        recyclerView = findViewById(R.id.rv_data) // Sesuaikan dengan ID RecyclerView di layout XML Anda
        recyclerView.layoutManager = LinearLayoutManager(this)

        val dbHelper = DBHelper(this)
        val dataList = dbHelper.getAllData() // Mengambil data dari SQLite

        adapter = AdapterLoading(this, dataList)
        recyclerView.adapter = adapter


    }
    private fun sendSQLiteDataToApi() {
        val dbHelper = DBHelper(this)
        val db = dbHelper.writableDatabase

        // Ambil data dari SQLite
        val dataList = dbHelper.getAllData()
        Log.d("testing",dataList.toString())
        val apiClient = RetrofitInstance.Create(this)
        val call = apiClient.sendDataToApi(dataList) // Menggunakan Retrofit untuk mendapatkan data dari API

        call.enqueue(object : retrofit2.Callback<Void> {
            override fun onResponse(call: retrofit2.Call<Void>, response: retrofit2.Response<Void>) {
                if (response.isSuccessful) {
                    if (response.isSuccessful) {
                        // Data berhasil dikirim ke API, Anda dapat melakukan tindakan sesuai kebutuhan
                        Log.d("LoadingActivity", "Data berhasil dikirim ke API")
                        dbHelper.deleteSentData(dataList)
                    } else {
                        // Gagal mengirim data ke API
                        Log.e("LoadingActivity", "Gagal mengirim data ke API")
                    }
                }

            }

            override fun onFailure(call: retrofit2.Call<Void>, t: Throwable) {
                Log.e("LoadingActivity", "Terjadi kesalahan dalam permintaan: ${t.message}")
            }
        })

        db.close()
    }
}