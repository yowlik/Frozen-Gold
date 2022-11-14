package com.ngelgames.heroc.koroutims

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.utils.widget.MotionButton
import com.ngelgames.heroc.R

class EnemActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)




        setContentView(R.layout.activity_enem)

        val c=findViewById<MotionButton>(R.id.loseeeeeers)
        c.setOnClickListener {

            Intent(this@EnemActivity, IgraiSoMnoi::class.java).also { startActivity(it) }

        }
    }
}