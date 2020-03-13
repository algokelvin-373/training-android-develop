package algorithm.kelvin.app.project.example.case_01

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

fun setFragment(fragmentManager: FragmentManager, fragmentString: String, fragment: Fragment, layout_fragment: Int) {
    val fragmentTransaction = fragmentManager.beginTransaction()
    fragmentManager.findFragmentByTag(fragmentString)
    fragmentTransaction.add(layout_fragment, fragment, fragmentString)
    fragmentTransaction.commit()
}