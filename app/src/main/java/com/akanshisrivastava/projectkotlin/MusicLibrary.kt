package com.akanshisrivastava.projectkotlin

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.widget.AdapterView.OnItemClickListener
import android.widget.ListView
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class MusicLibrary : AppCompatActivity() {
    private var musicList: ListView? = null
    private var itemClicked: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_music_library)

        val libParent: RelativeLayout = findViewById(R.id.library_rel)
        musicList = findViewById(R.id.music_list)

        val animationDrawable = libParent.background as AnimationDrawable
        animationDrawable.setEnterFadeDuration(2000)
        animationDrawable.setExitFadeDuration(2000)
        animationDrawable.start()

        val songList = ArrayList<String>()
        songList.add("Feels Right")
        songList.add("Starfire")
        songList.add("Cradles")
        songList.add("Break Away")
        songList.add("Love Me")

        val libraryAdapter = LibraryAdapter(applicationContext, songList)
        musicList!!.adapter = libraryAdapter
        musicList!!.onItemClickListener =
            OnItemClickListener { _, _, position, _ ->
                itemClicked = musicList!!.getItemAtPosition(position) as String
                val intent = Intent(this@MusicLibrary, NowPlaying::class.java)
                intent.putExtra("Song Selected", itemClicked)
                startActivity(intent)
            }
    }
}
