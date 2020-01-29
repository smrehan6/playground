package smr.playground.base

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    companion object {
        val TAG = this::class.java.simpleName!!
    }

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
}