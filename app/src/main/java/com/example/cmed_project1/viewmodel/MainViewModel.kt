package com.example.cmed_project1.viewmodel

import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import androidx.lifecycle.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class MainViewModel(private val context: Context) : ViewModel() {

    private lateinit var downloadManager: DownloadManager
    private var downloadId: Long = -1

    private val _downloadProgress = MutableLiveData<Int>()
    val downloadProgress: LiveData<Int>
        get() = _downloadProgress

    // Other ViewModel code

    // Update progress method
    private fun updateProgress(progress: Int) {
        _downloadProgress.postValue(progress)
    }

    fun startDownload(url: String) {
        downloadManager = context.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
        val request = DownloadManager.Request(Uri.parse(url))
            .setTitle("Downloading File")
            .setDescription("Downloading")
            .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
        downloadId = downloadManager.enqueue(request)
    }

}