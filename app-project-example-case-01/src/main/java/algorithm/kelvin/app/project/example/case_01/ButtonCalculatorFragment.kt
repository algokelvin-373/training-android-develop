package algorithm.kelvin.app.project.example.case_01

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_button_calculator.*

class ButtonCalculatorFragment : Fragment() {
    private val mLayerCalculatorFragment = LayerCalculatorFragment()
    private val extraNumber = LayerCalculatorFragment.EXTRA_NUMBER
    private val extraEquals = LayerCalculatorFragment.EXTRA_EQUALS

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_button_calculator, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mBundle = Bundle()
        buttonOne.setOnClickListener {
            mBundle.putString(extraNumber, "1")
            mLayerCalculatorFragment.arguments = mBundle
        }
    }


}
