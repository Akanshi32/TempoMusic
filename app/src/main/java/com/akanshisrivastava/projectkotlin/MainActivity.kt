package com.akanshisrivastava.projectkotlin

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val animationDrawable = main_rel.background as AnimationDrawable

        animationDrawable.setEnterFadeDuration(2000)
        animationDrawable.setExitFadeDuration(2000)
        animationDrawable.start()

        library.setOnClickListener {
            val i = Intent(this@MainActivity, MusicLibrary::class.java)
            startActivity(i)
        }

        explore.setOnClickListener {
            val i = Intent(this@MainActivity, ExploreMusic::class.java)
            i.putExtra("Song Selected", "Apocalypse")
            startActivity(i)
        }

        premium.setOnClickListener {
            val i = Intent(this@MainActivity, Premium::class.java)
            startActivity(i)
        }
    }
}
