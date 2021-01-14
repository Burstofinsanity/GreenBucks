    package com.bornintelligence.nedbankgreenbucks

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.RadioButton

    class retailer : AppCompatActivity() {

        private lateinit var mHandler: Handler
        private lateinit var mRun:Runnable
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retailer)
        hideSystemUI()


        findViewById<RadioButton>(R.id.retVal).setOnClickListener { nextSlide() }
        findViewById<RadioButton>(R.id.retVal2).setOnClickListener { nextSlide() }
        findViewById<RadioButton>(R.id.retVal3).setOnClickListener { nextSlide() }
        findViewById<RadioButton>(R.id.retVal4).setOnClickListener { nextSlide() }
        findViewById<RadioButton>(R.id.retVal5).setOnClickListener { nextSlide() }
        findViewById<RadioButton>(R.id.retVal6).setOnClickListener { nextSlide() }
        findViewById<RadioButton>(R.id.retVal7).setOnClickListener { nextSlide() }
        findViewById<RadioButton>(R.id.retVal8).setOnClickListener { nextSlide() }
        findViewById<RadioButton>(R.id.retVal9).setOnClickListener { nextSlide() }
        findViewById<RadioButton>(R.id.retVal10).setOnClickListener { nextSlide() }
        findViewById<RadioButton>(R.id.retVal11).setOnClickListener { nextSlide() }
        findViewById<RadioButton>(R.id.retVal12).setOnClickListener { nextSlide() }
        findViewById<RadioButton>(R.id.retVal13).setOnClickListener { nextSlide() }
        findViewById<RadioButton>(R.id.retVal14).setOnClickListener { nextSlide() }
        findViewById<RadioButton>(R.id.retVal15).setOnClickListener { nextSlide() }


    }

        private fun nextSlide(){

            mHandler = Handler()

            mRun = Runnable {
                val intent = Intent(this,savings::class.java)
                startActivity(intent)
            }
            mHandler.postDelayed(mRun,500)
        }

        private fun hideSystemUI() {
            window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_IMMERSIVE
                    or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_FULLSCREEN)
        }
}
