package com.muhammedkursatgokgun.kotlinworkmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.work.Constraints
import androidx.work.Data
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequest
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.PeriodicWorkRequest
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkRequest
import java.time.Period
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
/*
        var myWorkRequest : WorkRequest = OneTimeWorkRequestBuilder<RefleshDatabase>()
            .setConstraints(constraint)
            .setInputData(data)
            .setInitialDelay(5,TimeUnit.SECONDS)
            .addTag("tagNumber")
            .build()
        WorkManager.getInstance(this).enqueue(myWorkRequest)

 */
        /*var myWorkRequest : PeriodicWorkRequest = PeriodicWorkRequestBuilder<RefleshDatabase>(15,TimeUnit.MINUTES)
            .build()
        WorkManager.getInstance(this).enqueue(myWorkRequest)*/

        var workRequest : OneTimeWorkRequest = OneTimeWorkRequestBuilder<RefleshDatabase>()
            .setConstraints(constraint)
            .setInputData(data)
            .build()
        WorkManager.getInstance(this).beginWith(workRequest)
            .then(workRequest)
            .then(workRequest)
            .enqueue()
    }
}