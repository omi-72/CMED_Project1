package com.example.cmed_project1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.activity.viewModels
import com.example.cmed_project1.databinding.ActivityMainBinding
import com.example.cmed_project1.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.downloadProgress.observe(this, Observer { progress ->
            binding.progressBar.progress = progress
        })

        binding.startDownloadButton.setOnClickListener {
            viewModel.startDownload("http://dropbox.sandbox2000.com/intrvw/SampleVideo_1280x720_30mb.mp4")
            binding.progressBar.visibility = View.VISIBLE
        }

    }
}