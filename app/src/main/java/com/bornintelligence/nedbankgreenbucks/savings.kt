package com.bornintelligence.nedbankgreenbucks

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout

class savings : AppCompatActivity() {

    var listen = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_savings)
        hideSystemUI()
        findViewById<ConstraintLayout>(R.id.savings).setOnTouchListener { v, event ->
            if(listen)
            {
                listen = false
                val intent = Intent(this,q1::class.java)
                startActivity(intent)
            }
            true
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
