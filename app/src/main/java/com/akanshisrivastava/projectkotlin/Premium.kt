package com.akanshisrivastava.projectkotlin

import android.app.Dialog
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_premium.*


class Premium : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_premium)

        val animationDrawable = premium_rel.background as AnimationDrawable

        animationDrawable.setEnterFadeDuration(2000)
        animationDrawable.setExitFadeDuration(2000)
        animationDrawable.start()

        getpremium.setOnClickListener {
            showDialog()
            Toast.makeText(this, "Coming Soon!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun showDialog() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.dialog_layout)
        val closeBtn = dialog.findViewById(R.id.closeBtn) as ImageView
        closeBtn.setOnClickListener { dialog.dismiss() }
        dialog.show()

    }
}
