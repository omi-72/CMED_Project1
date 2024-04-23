package com.example.cmed_project1.viewmodel

import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import androidx.lifecycle.ViewModel

class MainViewModel(private val context: Context) : ViewModel() {

    private lateinit var downloadManager: DownloadManager
    private var downloadId: Long = -1

    fun startDownload(url: String) {
        downloadManager = context.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
        val request = DownloadManager.Request(Uri.parse(url))
            .setTitle("Downloading File")
            .setDescription("Downloading")
            .setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE)
        downloadId = downloadManager.enqueue(request)
    }

}