package com.example.mummy

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button
import android.widget.RelativeLayout


class MainActivity : AppCompatActivity() {

    private lateinit var buttonBanner: Button
    private lateinit var buttonInter: Button
    private lateinit var buttonReward: Button
    private lateinit var bannerLayout: RelativeLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeComponent()
        buttonBanner.setOnClickListener {
            AdsManager(this).showBanner(bannerLayout)
        }

        buttonInter.setOnClickListener {
            AdsManager(this).showInterstitial()
        }

        buttonReward.setOnClickListener {
            AdsManager(this).showReward()
        }

    }
    fun initializeComponent(){
        AdsManager(this).initialize()

        bannerLayout = findViewById(R.id.bannerLayout)

        buttonBanner = findViewById(R.id.buttonBanner)
        buttonInter= findViewById(R.id.buttonInter)
        buttonReward = findViewById(R.id.buttonReward)
    }
}
