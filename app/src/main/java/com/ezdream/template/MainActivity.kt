package com.ezdream.template

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ezdream.template.util.UiUtil.getDuration
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val duration = getDuration(applicationContext,R.drawable.splash_3)
        val background = object : Thread() {
            override fun run() {
                try {
                    sleep(duration.toLong())
                    val intent = Intent(baseContext, HomeActivity::class.java)
                    startActivity(intent)
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
                }catch (e : Exception){
                    e.printStackTrace()
                }
            }
        }
        background.start()
    }
}