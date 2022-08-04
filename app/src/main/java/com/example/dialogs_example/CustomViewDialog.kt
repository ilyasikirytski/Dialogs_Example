package com.example.dialogs_example

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class CustomViewDialog : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            // Get the layout inflater
            val inflater = requireActivity().layoutInflater;

            // Inflate and set the layout for the dialog
            // Pass null as the parent view because its going in the dialog layout
            builder.setView(inflater.inflate(R.layout.custom_view_dialog, null))
                // Add action buttons
                .setPositiveButton(R.string.signin,
                    DialogInterface.OnClickListener { dialog, id ->
                        // sign in the user ...
                        Toast.makeText(activity, "Signin...", Toast.LENGTH_SHORT).show()
                    })
                .setNegativeButton(R.string.cancel,
                    DialogInterface.OnClickListener { dialog, id ->
                        getDialog()?.cancel()
                        Toast.makeText(activity, "canceled", Toast.LENGTH_SHORT).show()
                    })
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}