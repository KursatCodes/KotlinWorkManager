package com.muhammedkursatgokgun.kotlinworkmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.work.Constraints
import androidx.work.Data
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkRequest
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data = Data.Builder().putInt("intKey",2).build()

        val constraint = Constraints.Builder()
            //.setRequiredNetworkType(NetworkType.CONNECTED)
            .setRequiresCharging(false)
            .build()

        var myWorkRequest : WorkRequest = OneTimeWorkRequestBuilder<RefleshDatabase>()
            .setConstraints(constraint)
            .setInputData(data)
            .setInitialDelay(5,TimeUnit.SECONDS)
            .addTag("tagNumber")
            .build()
        WorkManager.getInstance(this).enqueue(myWorkRequest)
    }
}