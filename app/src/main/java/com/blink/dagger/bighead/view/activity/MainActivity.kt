package com.blink.dagger.bighead.view.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.View
import android.widget.ImageView
import com.blink.dagger.bighead.R
import com.blink.dagger.bighead.view.fragment.MeizhiFragment
import com.blink.dagger.bighead.view.fragment.MovieFragment
import com.blink.dagger.bighead.view.fragment.MusicFragment
import com.blink.dagger.bighead.view.fragment.ReadFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),View.OnClickListener {

    var tabImgs: Array<ImageView>? = null
    var contentFragment: Array<Fragment>? = null
    val imgRes = intArrayOf(R.drawable.ic_read_unselected, R.drawable.ic_movie_unselected, R.drawable.ic_music_unselected,R.drawable.ic_home_unselected)
    val imgSelectRes = intArrayOf(R.drawable.ic_read_selected, R.drawable.ic_movie_selected, R.drawable.ic_music_selected,R.drawable.ic_home_selected)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init() {
        tabImgs = arrayOf(readImg, movieImg, musicImg, likeImg)
        readImg.setOnClickListener(this)
        movieImg.setOnClickListener(this)
        musicImg.setOnClickListener(this)
        likeImg.setOnClickListener(this)
        aboutImg.setOnClickListener(this)
        contentFragment = arrayOf(ReadFragment(), MovieFragment(), MusicFragment(), MeizhiFragment())
        supportFragmentManager.beginTransaction().add(R.id.fl_content, (contentFragment as Array<Fragment>)[0]).commit()
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.readImg -> {
                setCurrentTab(0)
                homeTitle.setText("一个阅读")}
            R.id.movieImg -> {
                setCurrentTab(1)
                homeTitle.setText("一部电影")
            }
            R.id.musicImg -> {
                setCurrentTab(2)
                homeTitle.setText("一首音乐")
            }
            R.id.likeImg -> {
                setCurrentTab(3)
                homeTitle.setText("不止一个妹子")
            }
            R.id.aboutImg -> {
                val intent:Intent = Intent(this,AboutActivity::class.java)
                startActivity(intent)
            }
        }
    }

    fun setCurrentTab(index:Int){
        for (i in 0..tabImgs!!.size - 1) {
            if (i == index) {
                (tabImgs as Array<ImageView>)[i].setImageResource(imgSelectRes[i])
                if (contentFragment!![i].isAdded) {
                    supportFragmentManager.beginTransaction().show((contentFragment as Array<Fragment>)[i]).commit()
                } else {
                    supportFragmentManager.beginTransaction().add(R.id.fl_content, (contentFragment as Array<Fragment>)[i]).commit()
                }
            } else {
                (tabImgs as Array<ImageView>)[i].setImageResource(imgRes[i])
                if (contentFragment!![i].isAdded) {
                    supportFragmentManager.beginTransaction().hide((contentFragment as Array<Fragment>)[i]).commit()
                }
            }
        }
    }

}
