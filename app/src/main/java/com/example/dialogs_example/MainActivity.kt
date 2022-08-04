package com.example.dialogs_example

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentActivity

class MainActivity : FragmentActivity(), NoticeDialogFragment.NoticeDialogListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val simpleDialogButton = findViewById<Button>(R.id.simpleDialogButton)
        val alertDialogButton = findViewById<Button>(R.id.alertButton)
        val alertDialogListButton = findViewById<Button>(R.id.alertDialogList)
        val dialogWithCheckboxesButton = findViewById<Button>(R.id.dialogWithCheckBoxes)
        val customViewDialogButton = findViewById<Button>(R.id.customDialogButton)
        val activityAsDialogButton = findViewById<Button>(R.id.activityAsDialogButton)
        val deliverBackButton = findViewById<Button>(R.id.deliverBackButton)
        val dialogAsAny = findViewById<Button>(R.id.dialogAsAny)


        simpleDialogButton.setOnClickListener {
            val startGameDialogFragment = StartGameDialogFragment()
            startGameDialogFragment.show(supportFragmentManager, "dialog")
        }

        alertDialogButton.setOnClickListener {
            val startAlertDialog = AlertDialog()
            startAlertDialog.chainSetter(this)
        }

        alertDialogListButton.setOnClickListener {
            val alertDialogList = AlertDialogList()
            alertDialogList.show(supportFragmentManager, "alertDialogList")
        }

        dialogWithCheckboxesButton.setOnClickListener {
            val dialogWithCheckboxes = DialogWithCheckboxes()
            dialogWithCheckboxes.show(supportFragmentManager, "dialogWithCheckboxes")
        }

        customViewDialogButton.setOnClickListener {
            val customViewDialog = CustomViewDialog()
            customViewDialog.show(supportFragmentManager, "customViewDialog")
        }

        activityAsDialogButton.setOnClickListener {
            startActivity(Intent(this, MainActivity2::class.java))
        }

        dialogAsAny.setOnClickListener {
            startActivity(Intent(this, MainActivity3::class.java))
        }

        deliverBackButton.setOnClickListener {
            val dialog = NoticeDialogFragment()
            dialog.show(supportFragmentManager, "dialogFragment")
        }
    }

    override fun onDialogPositiveClick(dialog: DialogFragment) {
        Toast.makeText(this, "Positive", Toast.LENGTH_SHORT).show()
    }

    override fun onDialogNegativeClick(dialog: DialogFragment) {
        Toast.makeText(this, "Negative", Toast.LENGTH_SHORT).show()
    }
}