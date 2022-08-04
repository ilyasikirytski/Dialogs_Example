package com.example.dialogs_example

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class AlertDialogList : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle(R.string.pick_color)
                .setItems(R.array.colors_array,
                    DialogInterface.OnClickListener { dialog, which ->
                        // The 'which' argument contains the index position
                        // of the selected item
                        Toast.makeText(activity, which.toString(), Toast.LENGTH_SHORT).show()
                    })
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}