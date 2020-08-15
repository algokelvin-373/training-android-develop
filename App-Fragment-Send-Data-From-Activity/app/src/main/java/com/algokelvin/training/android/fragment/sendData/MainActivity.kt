package com.algokelvin.training.android.fragment.sendData

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
    }

    private fun setTabLayout(tabLayout: TabLayout) {
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabReselected(tab: TabLayout.Tab?) { }
            override fun onTabUnselected(tab: TabLayout.Tab?) { }
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when(tab?.position){
                    0 -> makeCurrentFragment(FragmentOne())
                    else -> makeCurrentFragment(FragmentTwo())
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