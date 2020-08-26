package com.algokelvin.training.android.fragment.sendData

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var tabPosition: Int? = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tabLayout = findViewById<TabLayout>(R.id.tabLayout_Material)
        tabLayout.addTab(tabLayout.newTab().setText("Page One"))
        tabLayout.addTab(tabLayout.newTab().setText("Page Two"))
        tabLayout.tabGravity = TabLayout.GRAVITY_FILL
        setTabLayout(tabLayout)

        edtText.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) { }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) { }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s?.length == 5) {
                    val bundle = Bundle()
                    bundle.putString("textInput", s.toString())
                    when(tabPosition) {
                        0 -> {
                            val fragmentOne = FragmentOne()
                            fragmentOne.arguments = bundle
                            makeCurrentFragment(fragmentOne)
                        }
                        1 -> {
                            val fragmentTwo = FragmentTwo()
                            fragmentTwo.arguments = bundle
                            makeCurrentFragment(fragmentTwo)
                        }
                    }
                }
            }
        })
    }

    private fun setTabLayout(tabLayout: TabLayout) {
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabReselected(tab: TabLayout.Tab?) { }
            override fun onTabUnselected(tab: TabLayout.Tab?) { }
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when(tab?.position){
                    0 -> {
                        Log.i("fragment", "You in fragment One")
                        makeCurrentFragment(FragmentOne())
                    }
                    else -> {
                        Log.i("fragment", "You in fragment Two")
                        makeCurrentFragment(FragmentTwo())
                    }
                }
                tabPosition = tab?.position
                edtText.setText("")
            }
        })
    }
    private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameLayout, fragment)
            commit()
        }
    }
}