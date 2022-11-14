package com.ngelgames.heroc.koroutims

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.utils.widget.MotionButton
import com.ngelgames.heroc.R

class YourActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_your)
        val c=findViewById<MotionButton>(R.id.winnnnnnnners)
        c.setOnClickListener {

                Intent(this@YourActivity, IgraiSoMnoi::class.java).also { startActivity(it) }

        }
    }
}