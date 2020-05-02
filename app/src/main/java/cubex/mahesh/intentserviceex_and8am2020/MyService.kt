package cubex.mahesh.intentserviceex_and8am2020

import android.app.IntentService
import android.content.Intent
import android.util.Log
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.URL

class MyService : IntentService("and8am")
{
    override fun onHandleIntent(intent: Intent?) {
     var _url = URL("http://129.232.170.227/ODIStockmanagementApi/api/Account/LoginAPi?UserName=${MainActivity.name}&Password=${MainActivity.pass}")
     var isr:InputStream = _url.openStream()
     var breader:BufferedReader  = BufferedReader(InputStreamReader(isr))
      var resp:StringBuffer = StringBuffer("")
        var lineData:String? = breader.readLine()
        while (lineData != null){
            resp.append(lineData)
            lineData = breader.readLine()
        }
        Log.i("and8am",resp.toString())

        var i = Intent()
        i.setAction("and8am_dataload_done")
        i.putExtra("resp",resp.toString())
        sendBroadcast(i)
    }
}