package cubex.mahesh.intentserviceex_and8am2020

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    companion object{
        var name:String? = null
        var pass:String? = null
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        login.setOnClickListener {
                name = et1.text.toString()
                pass = et2.text.toString()
                var i = Intent(this@MainActivity,
                                            MyService::class.java)
                startService(i)
        }

        var iFilter = IntentFilter()
        iFilter.addAction("and8am_dataload_done")
        registerReceiver(MyReceiver(),iFilter)
    }

    class MyReceiver:BroadcastReceiver()
    {
        override fun onReceive(context: Context?, intent: Intent?) {
                var resp = intent?.getStringExtra("resp")
                var obj:JSONObject = JSONObject(resp)
    (context as MainActivity).tv1.setText(obj.getString("Status"))
        }
    }
}
