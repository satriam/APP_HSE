package com.example.hseapp

import AdapterQuestion
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ScrollView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hseapp.dataclass.Question
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HaulingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hauling)

    }
}
