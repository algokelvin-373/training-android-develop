package algorithm.kelvin.app.project.example.case_01

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_layer_calculator.*

class LayerCalculatorFragment : Fragment() {
    private var textCalculator = ""
    companion object {
        var EXTRA_NUMBER = "extra_number"
        var EXTRA_OPERATOR = "extra_operator"
        var EXTRA_EQUALS = "extra_equals"
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_layer_calculator, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonNumber = arguments?.getString(EXTRA_NUMBER)
        textCalculator += buttonNumber
        tvLayer.text = textCalculator
    }

}
