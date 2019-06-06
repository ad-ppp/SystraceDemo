package com.jacky.systracedemo

import android.os.Build
import android.os.Bundle
import android.os.Trace
import android.support.annotation.RequiresApi
import android.support.v7.app.AppCompatActivity

@RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Trace.beginSection("start onCreate")

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Trace.endSection()
    }
}
