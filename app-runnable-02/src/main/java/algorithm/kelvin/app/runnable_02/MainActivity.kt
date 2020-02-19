package algorithm.kelvin.app.runnable_02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var x = 0
        val handler = Handler()
        val runnable = object: Runnable {
            override fun run() {
                Log.i("android-runnable", "Runnable is work, x = $x")
                if (++x == 5) {
                    Log.i("android-runnable", "Runnable has been stopped")
                    handler.removeCallbacks(this)
                }
                else {
                    handler.postDelayed(this, 1000)
                }
            }
        }
        Log.i("android-runnable", "Runnable start")
        handler.postDelayed(runnable, 5000)
        Log.i("android-runnable", "You have been called Runnable")

    }
}
