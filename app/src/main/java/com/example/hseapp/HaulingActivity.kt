package com.example.hseapp

import AdapterQuestion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.RadioGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.hseapp.dataclass.Question
import com.example.hseapp.retrofit.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HaulingActivity : AppCompatActivity() {
    private lateinit var radioGroup: RadioGroup
    private lateinit var dangerLayout: LinearLayout
    private lateinit var dangerCodeEditText: EditText
    private lateinit var keteranganEditText: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hauling)





// Inisialisasi RecyclerView dan adapter
    val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
    recyclerView.layoutManager = LinearLayoutManager(this)
    val adapter = AdapterQuestion()
    recyclerView.adapter = adapter

// Ambil data dari API dan setel data ke adapter
    val apiClient = RetrofitInstance.Create(this)
    val filters = mapOf("filters[jenis]\$eq" to "LP")
    apiClient.getPertanyaans(filters).enqueue(object : Callback<Question> {
        override fun onResponse(call: Call<Question>, response: Response<Question>) {
            if (response.isSuccessful) {
                val questionData = response.body()?.data
                Log.d("sdsds",questionData.toString())
                if (questionData != null) {
                    adapter.setQuestions(questionData)
                }
            } else {
                // Handle kesalahan jika permintaan tidak berhasil
            }
        }

        override fun onFailure(call: Call<Question>, t: Throwable) {
            // Handle kesalahan jaringan atau kesalahan lainnya
            Log.d("sdsds",t.toString())
        }
    })

    }
}