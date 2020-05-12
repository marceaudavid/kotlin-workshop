package com.example.kotlinworkshop

import android.Manifest
import android.Manifest.permission
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.ListView
import android.widget.SimpleCursorAdapter
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class ContactActivity : AppCompatActivity() {

    private val projection: Array<String> = arrayOf(
        ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
        ContactsContract.CommonDataKinds.Phone.NUMBER
    )

    private var selectionClause: String? = null
    private var selectionArgs: Array<String>? = null
    private lateinit var list: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)
        list = findViewById(R.id.list)
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_CONTACTS), 1)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            1 -> {
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    var cursor = contentResolver.query(
                        ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                        projection,
                        null,
                        emptyArray(),
                        ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME + " ASC"
                    )

                    val wordListItems = intArrayOf(R.id.name, R.id.number)

                    var cursorAdapter = SimpleCursorAdapter(
                        this,             // The application's Context object
                        R.layout.item_contact,           // A layout in XML for one row in the ListView
                        cursor,                        // The result from the query
                        projection,               // A string array of column names in the cursor
                        wordListItems,                 // An integer array of view IDs in the row layout
                        0                               // Flags (usually none are needed)
                    )

                    list.adapter = cursorAdapter

                } else {
                    Toast.makeText(this, "You denied the permission to read contacts", Toast.LENGTH_LONG)
                }
                return
            }
        }
    }
}
