package algorithm.kelvin.app.fragment_01

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class TwoFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_two, container, false)
    }

    override fun onResume() {
        super.onResume()
        Log.i("fragment-resume", "Resume 2 is start")
    }

    override fun onStart() {
        super.onStart()
        Log.i("fragment-start", "Start 2 is start")
    }

    override fun onStop() {
        super.onStop()
        Log.i("fragment-stop", "Stop 2 is start")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("fragment-destroy", "Destroy 2 is start")
    }

}
