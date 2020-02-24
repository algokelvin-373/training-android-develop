package algorithm.kelvin.app.activity_01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        Log.i("activity-one", "Start is run")
    }

    override fun onResume() {
        super.onResume()
        Log.i("activity-one", "Resume is run")
    }

    override fun onPause() {
        super.onPause()
        Log.i("activity-one", "Pause is run")
    }

    override fun onStop() {
        super.onStop()
        Log.i("activity-one", "Stop is run")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("activity-one", "Destroy is run")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("activity-one", "Restart is run")
    }
}
