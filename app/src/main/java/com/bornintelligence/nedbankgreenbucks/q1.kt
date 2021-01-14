package com.bornintelligence.nedbankgreenbucks

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class q1 : AppCompatActivity() {

    private lateinit var mHandler: Handler
    private lateinit var mRun:Runnable
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_q1)
        hideSystemUI()
        mHandler = Handler()
        val correct = findViewById<TextView>(R.id.correct)
        findViewById<TextView>(R.id.answer1).setOnClickListener {
            correct.setText(R.string.correct)
            correct.visibility = View.VISIBLE
            mRun = Runnable {
                val intent = Intent(this,q2::class.java)
                startActivity(intent)
            }
            mHandler.postDelayed(mRun,500)
        }
        findViewById<TextView>(R.id.answer2).setOnClickListener { correct.setText(R.string.incorrect)
            correct.visibility = View.VISIBLE }
        findViewById<TextView>(R.id.answer3).setOnClickListener{ correct.setText(R.string.incorrect)
            correct.visibility = View.VISIBLE }
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
