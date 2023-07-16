package com.muhammedkursatgokgun.kotlinworkmanager

import android.content.Context
import android.widget.TextView
import androidx.work.Worker
import androidx.work.WorkerParameters

class RefleshDatabase(val context: Context, workerParams: WorkerParameters) :
    Worker(context, workerParams) {
    override fun doWork(): Result {
        val getData = inputData
        var number = getData.getInt("intKey",0)
        refleshDB(number)
        return Result.success()
    }
    private fun refleshDB(number1:Int){
        val myDatabase = context.getSharedPreferences(
            "com.muhammedkursatgokgun.kotlinworkmanager",Context.MODE_PRIVATE)
        var mySavedNumber = myDatabase.getInt("myNumber",0)
        mySavedNumber = mySavedNumber + number1
        myDatabase.edit().putInt("myNumber",mySavedNumber).apply()
        println("My number: "+mySavedNumber)
    }
}