package algorithm.kelvin.app.fragment_01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var valueFragment = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnFragmentOne.setOnClickListener { setFragment(supportFragmentManager, OneFragment::class.java.simpleName, OneFragment()) }
        btnFragmentTwo.setOnClickListener { setFragment(supportFragmentManager, TwoFragment::class.java.simpleName, TwoFragment()) }
    }

    private fun setFragment(fragmentManager: FragmentManager, fragmentString: String, fragment: Fragment) {
        Log.i("fragment-value", "value $valueFragment")
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentManager.findFragmentByTag(fragmentString)
        when(valueFragment) {
            0 -> fragmentTransaction.add(R.id.layoutFragment, fragment, fragmentString)
            else -> fragmentTransaction.replace(R.id.layoutFragment, fragment, fragmentString)
        }
        fragmentTransaction.commit()
        valueFragment = 1
    }
}
