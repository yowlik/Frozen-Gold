package com.ngelgames.heroc

import android.app.Application
import com.my.tracker.MyTracker
import com.onesignal.OneSignal
import com.orhanobut.hawk.Hawk
import java.util.*




class BiggestClassser: Application() {




    companion object {
        val teLassssssssTAsrsf = "engold.live/go.php?to=1&"

        const val koAAAAAAaaastsssssssssras = ""



        const val esPPPPPpariiiiiras = "1v4b"


        const val trevogaaaaaaskekkEs = "757a38e7-6e69-4741-8e17-67aa419529e5"


        val Opsleeeeeeeeeeeeeesme1 = "http://froz"





        var kriAwrrrrraswaKKasss: String? = "myID"


        var poEassssJoiakkkkkkkkkas: String? = "instID"
    }



    override fun onCreate() {
        super.onCreate()
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
        // OneSignal Initialization
        OneSignal.initWithContext(this)
        OneSignal.setAppId(trevogaaaaaaskekkEs)
        Hawk.init(this).build()
        val seiiiiAS29lsa=getSharedPreferences("PREFS_NAME",0)

        val aleeeeeeeeeeKeoslle = MyTracker.getTrackerParams()

        val KppArrrrrrrrrrraslcxsa = MyTracker.getTrackerConfig()

        val oIpiiiiiiiiiiirsSOooooos = MyTracker.getInstanceId(this)

        KppArrrrrrrrrrraslcxsa.isTrackingLaunchEnabled=true

        if(seiiiiAS29lsa.getBoolean("my_first_time",true)){
            val idiiiiiiiiiSjjkekeksa = UUID.randomUUID().toString()
            aleeeeeeeeeeKeoslle.setCustomUserId(idiiiiiiiiiSjjkekeksa)
            Hawk.put(kriAwrrrrraswaKKasss, idiiiiiiiiiSjjkekeksa)
            Hawk.put(poEassssJoiakkkkkkkkkas, oIpiiiiiiiiiiirsSOooooos)
        }else{
            val idiJoakkkkkkklen= Hawk.get(kriAwrrrrraswaKKasss,"null")
            aleeeeeeeeeeKeoslle.setCustomUserId(idiJoakkkkkkklen)
        }
        MyTracker.initTracker(koAAAAAAaaastsssssssssras, this)
    }
}
