package com.akanshisrivastava.projectkotlin

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class ExploreMusic : AppCompatActivity() {
    private var genreList: ListView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_explore_music)

        val exploreParent: RelativeLayout = findViewById(R.id.explore_rel)
        genreList = findViewById(R.id.genrelist)

        val animationDrawable =
            exploreParent.background as AnimationDrawable
        animationDrawable.setEnterFadeDuration(2000)
        animationDrawable.setExitFadeDuration(2000)
        animationDrawable.start()

        val genreList = ArrayList<String>()
        genreList.add("Pop")
        genreList.add("Rock")
        genreList.add("Indie")
        genreList.add("K-Pop")
        genreList.add("Jazz")
        genreList.add("Metal")
        genreList.add("Country")
        genreList.add("Blues")

        val genreAdapter = GenreAdapter(applicationContext, genreList)
        this.genreList!!.adapter = genreAdapter
        this.genreList!!.onItemClickListener =
            AdapterView.OnItemClickListener { _, _, _, _ ->
                Toast.makeText(this, "Yay! Tempo will get new music, soon.", Toast.LENGTH_LONG).show()
            }
    }
}
