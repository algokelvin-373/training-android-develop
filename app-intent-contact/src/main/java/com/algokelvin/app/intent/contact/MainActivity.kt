package com.algokelvin.app.intent.contact

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val REQUEST_SELECT_CONTACT = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_contact.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK).apply {
                type = ContactsContract.Contacts.CONTENT_TYPE
            }
            if (intent.resolveActivity(packageManager) != null) {
                startActivityForResult(intent, REQUEST_SELECT_CONTACT)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_SELECT_CONTACT && resultCode == RESULT_OK) {
            val contactUri: Uri = data?.data ?: return
            Log.i("uriContact", contactUri.toString())
            val projection: Array<String> = arrayOf(ContactsContract.CommonDataKinds.Phone.NUMBER)
            contentResolver.query(contactUri, null, null, null, null).use { cursor ->
                //if the cursor return is valid, get the phone
                if (cursor?.moveToFirst()!!) {
                    val numberIndex = cursor.getColumnIndex(ContactsContract.Contacts._ID)
                    val name = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)
                    val number = cursor.getString(numberIndex)
                    Log.d("contact-number", "Detai : $number # ${name}")
                }
            }
        }
    }
}
