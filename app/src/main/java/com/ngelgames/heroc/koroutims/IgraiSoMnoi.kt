package com.ngelgames.heroc.koroutims

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.ImageView
import com.ngelgames.heroc.R
import com.ngelgames.heroc.databinding.ActivityIgraiSoMnoiBinding

class IgraiSoMnoi : AppCompatActivity() {
    lateinit var FrozenFruitsMakeTruis:ActivityIgraiSoMnoiBinding
    lateinit var rolikiriTroliki:Array<String>
    lateinit var yourroll:Array<String>

    lateinit var enemroll:Array<String>
    private var TimeJokarsllla: CountDownTimer?=null
    lateinit var youriikiTrsosa:Array<ImageView>
    lateinit var eniliBenikisa:Array<ImageView>
    lateinit var clicked:String
    var yoursca=0
    var enemsca=0
    var fruit1="oran"
    var fruit2="oran"
    var fruit3="oran"
    var fruit4="oran"
    var fruit5="oran"
    var fruit6="oran"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FrozenFruitsMakeTruis= ActivityIgraiSoMnoiBinding.inflate(layoutInflater)
        setContentView(FrozenFruitsMakeTruis.root)
        rolikiriTroliki= arrayOf("oran","peach","malin")
        youriikiTrsosa= arrayOf(FrozenFruitsMakeTruis.fruits4,FrozenFruitsMakeTruis.fruits5,FrozenFruitsMakeTruis.fruits6)
        eniliBenikisa= arrayOf(FrozenFruitsMakeTruis.fruits1,FrozenFruitsMakeTruis.fruits2,FrozenFruitsMakeTruis.fruits3)
        yourroll= arrayOf(fruit1,fruit2,fruit3)
        enemroll= arrayOf(fruit4,fruit5,fruit6)
        clicked="0"
        FrozenFruitsMakeTruis.spinnnnnners.setOnClickListener {
            if(clicked=="0"){
                TraaaaaaaaafiCKslalsa(550)
                clicked="1"
            }
        }

    }




    private fun chelostar(fruit:String,imfru:ImageView){
        if(fruit=="oran"){
            imfru.setImageResource(R.drawable.orangeice)
        }
        else if(fruit=="peach"){
            imfru.setImageResource(R.drawable.peachice)
        }
        else{
            imfru.setImageResource(R.drawable.malinice)
        }
    }
    private fun winsWithAcrtosa(){
        if(yourroll[0]==yourroll[1]&&yourroll[1]==yourroll[2]){
            yoursca=yoursca+10
            FrozenFruitsMakeTruis.yourascara.text="Your Score : $yoursca"
            if(yoursca==100){
                Intent(this@IgraiSoMnoi, YourActivity::class.java).also { startActivity(it) }
            }
        }
    }
    private fun NemeWinsTruuues(){
        if(enemroll[0]==enemroll[1]&&enemroll[1]==enemroll[2]){
            enemsca=enemsca+10
            FrozenFruitsMakeTruis.inemscara.text="Enemy Score : $enemsca"
            if(enemsca==100){
                Intent(this@IgraiSoMnoi, EnemActivity::class.java).also { startActivity(it) }
            }
        }
    }

    private fun TraaaaaaaaafiCKslalsa(Loeeeeeeeeeeestas:Long){

        TimeJokarsllla=object : CountDownTimer(Loeeeeeeeeeeestas,50){

            override fun onTick(TimeEl: Long) {

                for( i in 0..2){
                    yourroll[i]=rolikiriTroliki.random()
                    enemroll[i]=rolikiriTroliki.random()
                    chelostar(yourroll[i],youriikiTrsosa[i])
                    chelostar(enemroll[i],eniliBenikisa[i])
                }

            }
            override fun onFinish() {
                winsWithAcrtosa()
                clicked="0"
                NemeWinsTruuues()
            }

        }.start()

    }
}