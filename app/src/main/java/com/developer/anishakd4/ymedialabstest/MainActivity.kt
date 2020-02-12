package com.developer.anishakd4.ymedialabstest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.developer.anishakd4.ymedialabstest.fragments.OverviewFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().add(R.id.fragment, OverviewFragment()).commit()
    }
}
