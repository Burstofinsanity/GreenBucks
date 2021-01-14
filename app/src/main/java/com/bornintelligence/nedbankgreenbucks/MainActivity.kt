package com.bornintelligence.nedbankgreenbucks

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.MotionEventCompat

class MainActivity : AppCompatActivity() {
    var listen = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listen = true
        hideSystemUI()
        findViewById<ConstraintLayout>(R.id.mainActivity).setOnTouchListener { v, event ->
            if (listen) {
                listen = false
                val intent = Intent(this, information::class.java)
                startActivity(intent)
            }
            true
        }
        findViewById<ConstraintLayout>(R.id.mainActivity).setOnClickListener {

            val intent = Intent(this, information::class.java)
            startActivity(intent)

        }
    }

    override fun onResume() {
        listen = true
        super.onResume()
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
    