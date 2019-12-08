package smr.playground.base

import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {

    val TAG = this.javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.v(TAG, "onCreate")
        super.onCreate(savedInstanceState)
    }

    override fun onStart() {
        Log.v(TAG, "onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.v(TAG, "onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.v(TAG, "onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.v(TAG, "onStop")
        super.onStop()
    }

    override fun onRestart() {
        Log.v(TAG, "onRestart")
        super.onRestart()
    }

    override fun onDestroy() {
        Log.v(TAG, "onDestroy")
        super.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        Log.v(TAG, "onSaveInstanceState")
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        Log.v(TAG, "onRestoreInstanceState")
        super.onRestoreInstanceState(savedInstanceState)
    }

    fun showDialog(
        msg: String,
        title: String = "Alert",
        txtPositiveBtn: String = "OK",
        positiveListener: DialogInterface.OnClickListener? = null
    ) {
        AlertDialog.Builder(this).setTitle(title).setMessage(msg)
            .setPositiveButton(txtPositiveBtn, positiveListener)
            .create().show()
    }
}