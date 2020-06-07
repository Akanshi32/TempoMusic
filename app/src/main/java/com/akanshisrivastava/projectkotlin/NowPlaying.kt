package com.akanshisrivastava.projectkotlin

import android.content.Intent
import android.graphics.ColorFilter
import android.graphics.drawable.AnimationDrawable
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieProperty
import com.airbnb.lottie.SimpleColorFilter
import com.airbnb.lottie.model.KeyPath
import com.airbnb.lottie.value.LottieValueCallback
import kotlinx.android.synthetic.main.activity_now_playing.*


class NowPlaying : AppCompatActivity() {
    private var mediaPlayer: MediaPlayer? = null
    private var isPlaying = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_now_playing)

        val animationDrawable = now_playing_rel.background as AnimationDrawable
        animationDrawable.setEnterFadeDuration(2000)
        animationDrawable.setExitFadeDuration(2000)
        animationDrawable.start()

        val filter = SimpleColorFilter(resources.getColor(R.color.colorWhite))
        val keyPath = KeyPath("**")
        val callback = LottieValueCallback<ColorFilter>(filter)

        playpause.addValueCallback(keyPath, LottieProperty.COLOR_FILTER, callback)
        playpause.setMinAndMaxFrame(0, 32)
        playpause.playAnimation()

        val intent: Intent = intent
        val songName = intent.getStringExtra("Song Selected")
        song_name!!.text = songName

        mediaPlayer = when (songName) {
            "Feels Right" -> MediaPlayer.create(this@NowPlaying, R.raw.feels_right)
            "Starfire" -> MediaPlayer.create(this@NowPlaying, R.raw.starfire)
            "Cradles" -> MediaPlayer.create(this@NowPlaying, R.raw.cradles)
            "Break Away" -> MediaPlayer.create(this@NowPlaying, R.raw.break_away)
            "Love Me" -> MediaPlayer.create(this@NowPlaying, R.raw.love_me)
            else -> null
        }
        mediaPlayer!!.start()

        playpause!!.setOnClickListener {
            if (isPlaying) {
                isPlaying = false
                playpause.playAnimation()
                playpause.setMinAndMaxFrame(32, 60)
                mediaPlayer!!.pause()
            } else {
                isPlaying = true
                playpause.setMinAndMaxFrame(0, 32)
                playpause.playAnimation()
                mediaPlayer!!.start()
            }
        }
    }

    override fun onPause() {
        super.onPause()
        mediaPlayer!!.pause()
    }

    override fun onResume() {
        super.onResume()
        if (mediaPlayer != null) mediaPlayer!!.start()
        playpause.setMinAndMaxFrame(0, 32)
        playpause.playAnimation()
    }
}
