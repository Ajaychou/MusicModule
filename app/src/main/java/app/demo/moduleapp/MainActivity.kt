package app.demo.moduleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import app.demo.musicmodule.Callbacks
import app.demo.musicmodule.MusicClass
import app.demo.musicmodule.MusicModuleApp
import java.lang.Exception
import android.content.DialogInterface
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.appcompat.app.AlertDialog


class MainActivity : AppCompatActivity(), Callbacks {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MusicClass(this).getMusicFiles(this)
    }


    override fun onFiles(data: String?) {
        Log.d("tagged", ">>>>Files " + data)
    }

    override fun countFiles(count: Int) {
        Log.d("tagged", ">>>>Files " + count)
    }

    override fun onFailure(e: Exception?) {
        AlertDialog.Builder(this)
            .setTitle("Oops")
            .setMessage(e?.message)

            // Specifying a listener allows you to take an action before dismissing the dialog.
            // The dialog is automatically dismissed when a dialog button is clicked.
            .setPositiveButton(android.R.string.yes,
                DialogInterface.OnClickListener { dialog, which ->
                    // Continue with delete operation
                })

            // A null listener allows the button to dismiss the dialog and take no further action.
            .setNegativeButton(android.R.string.no, null)
            .setIcon(android.R.drawable.ic_dialog_alert)
            .show()
    }

}
