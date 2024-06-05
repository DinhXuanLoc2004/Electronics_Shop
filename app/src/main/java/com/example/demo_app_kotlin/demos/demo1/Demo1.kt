package com.example.demo_app_kotlin.demos.demo1

import android.icu.util.Calendar
import android.os.Handler
import android.util.Log

//fun main(){
//    printDay()
//}
//
//fun printDay() {
//    val nowDay = Calendar.getInstance()
//    Log.d("TAG", "onCreate: $nowDay")
//    val printNowDay = {
//        val day = nowDay.get(Calendar.DAY_OF_MONTH)
//        val month = nowDay.get(Calendar.MONTH) + 1
//        val year = nowDay.get(Calendar.YEAR)
//        Log.d("TAG", "printDay: $day/$month/$year")
//
//        if (checkNamNhuan(year)) Log.d("TAG", "$year là năm nhuận") else Log.d("TAG", "$year không phải là năm nhuận")
//        val dayOfWeek = nowDay.get(Calendar.DAY_OF_WEEK)
//        Log.d("TAG", "thứ $dayOfWeek")
//
//        val dayOfYear = nowDay.get(Calendar.DAY_OF_YEAR)
//        checkDayToNewYear(year,dayOfYear)
//    }
//    printNowDay()
//    val handler = Handler()
//    var giay = 0
//    var phut = 0
//    var gio = 0
//    fun renderS() {
//        handler.postDelayed(object : Runnable {
//            override fun run() {
//                giay += 1
//                if (giay >= 60){
//                    phut += 1
//                    giay = 0
//                }
//                if (phut >= 60){
//                    gio += 1
//                    phut = 0
//                }
//                Log.d("TAG", "run: $giay:$phut:$gio")
//                handler.postDelayed(this,1000)
//            }
//        }, 1000)
//    }
//    renderS()
//
//}
//
//fun checkNamNhuan(year: Int): Boolean{
//    if (year%4==0 && year%100!=0) return true else return false
//}
//
//fun checkDayToNewYear(nowYear: Int,dayOfYear: Int) {
//    var sumDayOfYear: Int
//    if (checkNamNhuan(nowYear)) sumDayOfYear = 366 else sumDayOfYear = 365
//    Log.d("TAG", "còn ${sumDayOfYear - dayOfYear} là đến ${nowYear + 1}")
//}