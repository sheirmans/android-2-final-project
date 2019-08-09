package com.ucsdextandroid2.android2final

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

 //       DataSource.getInstance().search("Android", 1, object : DataSource.Callback<List<JobItem>> {
 //          override fun onDataFetched(data: List<JobItem>?) {
 //            Log.d("test", "Job: " + data?.get(0).description)
 //          }
 //       })
    }
}