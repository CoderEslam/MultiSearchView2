package com.doubleclick.multisearchview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.doubleclick.multisearchview.`interface`.MultiSearchViewListener
import com.doubleclick.multisearchview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        binding.multiSearchView.setSearchViewListener(object : MultiSearchViewListener {
            override fun onItemSelected(index: Int, s: CharSequence) {
                Log.v("TEST", "onItemSelected: index: $index, query: $s")
            }

            override fun onTextChanged(index: Int, s: CharSequence) {
                Log.v("TEST", "changed: index: $index, query: $s")
            }

            override fun onSearchComplete(index: Int, s: CharSequence) {
                Log.v("TEST", "complete: index: $index, query: $s")
            }

            override fun onSearchItemRemoved(index: Int) {
                Log.v("TEST", "remove: index: $index")
            }

        })
    }
}