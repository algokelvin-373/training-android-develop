package com.algokelvin.training.android.fragment.app_edittext_copy_paste_replace

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var numberPhone = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText_Number_Phone.transformationMethod = null
        editText_Number_Phone.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                editText_Number_Phone.removeTextChangedListener(this)
                when {
                    numberPhone.startsWith("+62") -> editText_Number_Phone.setText(replaceRegexPhoneNumber("+62", "0", numberPhone))
                    numberPhone.startsWith("62") -> editText_Number_Phone.setText(replaceRegexPhoneNumber62(numberPhone))
                }
                editText_Number_Phone.addTextChangedListener(this)
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                numberPhone = s.toString()
            }
        })
    }

    fun replaceRegexPhoneNumber(regex: String, replaceRegex: String, numberPhone: String) = numberPhone.replace(regex, replaceRegex)
    fun replaceRegexPhoneNumber62(numberPhone: String) = "0"+numberPhone.substring(2, numberPhone.length)
}