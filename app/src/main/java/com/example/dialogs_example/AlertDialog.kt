package com.example.dialogs_example

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.widget.Toast

class AlertDialog {
    fun chainSetter(context: Context?) {
        // 1. Instantiate an <code><a href="/reference/android/app/AlertDialog.Builder.html">AlertDialog.Builder</a></code> with its constructor
        val builder: AlertDialog.Builder = context.let {
            AlertDialog.Builder(it)
        }
//        add buttons to dialog
        builder.apply {
            setPositiveButton(R.string.ok,
                DialogInterface.OnClickListener { dialog, id ->
                    // User clicked OK button
                    Toast.makeText(context, "ok", Toast.LENGTH_SHORT).show()
                })
            setNegativeButton(R.string.cancel,
                DialogInterface.OnClickListener { dialog, id ->
                    // User cancelled the dialog
                    Toast.makeText(context, "canceled", Toast.LENGTH_SHORT).show()
                })
        }
        // 2. Chain together various setter methods to set the dialog characteristics
        builder.setMessage(R.string.dialog_message)?.setTitle(R.string.dialog_title)
        // 3. Get the <code><a href="/reference/android/app/AlertDialog.html">AlertDialog</a></code> from <code><a href="/reference/android/app/AlertDialog.Builder.html#create()">create()</a></code>
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}