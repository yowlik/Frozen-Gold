package com.ngelgames.heroc.koroutims

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.ngelgames.heroc.BiggestClassser.Companion.esPPPPPpariiiiiras
import com.ngelgames.heroc.BiggestClassser.Companion.teLassssssssTAsrsf
import com.ngelgames.heroc.BiggestClassser.Companion.Opsleeeeeeeeeeeeeesme1
import com.ngelgames.heroc.databinding.ActivityMainBinding
import kotlinx.coroutines.*
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {



    lateinit var mainbindsactivity: ActivityMainBinding


    lateinit var KorrrrrrrrrlanTran: String


    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        mainbindsactivity = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainbindsactivity.root)
        KorrrrrrrrrlanTran = ""


        val trrrrrrrrrrrrreKloassssssssss = GlobalScope.launch(Dispatchers.IO) {
            KorrrrrrrrrlanTran = laraMaraKaraaSarrrrrrrrra()
        }


        runBlocking {
            try {
                trrrrrrrrrrrrreKloassssssssss.join()
                if (KorrrrrrrrrlanTran == esPPPPPpariiiiiras) {
                    Intent(applicationContext, IgraiSoMnoi::class.java).also { startActivity(it) }
                } else {
                    Intent(applicationContext, SiteraBezTebya::class.java).also { startActivity(it) }
                }
                finish()
            } catch (e: Exception) {
            }
        }
    }




    private fun aseuiEskkkkkkkkkkkeasa(TrrrrrrrrrevOkas: String) {
        val olasTraniiiiisdt = URL(TrrrrrrrrrevOkas)
        val TfffffffffffffffsaeLLlsa = olasTraniiiiisdt.openConnection() as HttpURLConnection
        try {
            val opeeeeeeeeeeNssssssskras = TfffffffffffffffsaeLLlsa.inputStream.bufferedReader().readText()
            if (opeeeeeeeeeeNssssssskras.isNotEmpty()) {

                KorrrrrrrrrlanTran = opeeeeeeeeeeNssssssskras
            }
        } catch (ex: Exception) {
        } finally {
            TfffffffffffffffsaeLLlsa.disconnect()
        }
    }




    private suspend fun laraMaraKaraaSarrrrrrrrra(): String {

        val ColaaaandTroland =
            "${Opsleeeeeeeeeeeeeesme1}${teLassssssssTAsrsf}"
        withContext(Dispatchers.IO) {
            aseuiEskkkkkkkkkkkeasa(ColaaaandTroland)
            Log.d("Check1C", ColaaaandTroland)
        }
        return KorrrrrrrrrlanTran



    }

}