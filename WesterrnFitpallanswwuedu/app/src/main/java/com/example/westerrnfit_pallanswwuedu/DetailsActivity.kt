package com.example.westerrnfit_pallanswwuedu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val num = intent.getStringExtra("num")
        val date = intent.getStringExtra("date")
        val type = intent.getStringExtra("type")
        val dur = intent.getStringExtra("dur")

        Log.d("HiSophie", "The info is $num $date $type $dur")

        val detailsFragment = DetailsFragment.newInstance(num!!, date!!, type!!, dur!!)
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.detailsFragment, detailsFragment, null).commit()

        /*
        supportFragmentManager.beginTransaction().apply {
            add(R.id.detailsFragment, detailsFragment, null)
            replace(R.id.detailsFragment, detailsFragment, null)
            commit()
        }*/
    }
}