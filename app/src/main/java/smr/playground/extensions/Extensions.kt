package smr.playground.extensions

import android.app.Activity
import android.content.DialogInterface
import androidx.appcompat.app.AlertDialog

fun Activity.showDialog(
    msg: String,
    title: String = "Alert",
    txtPositiveBtn: String = "OK",
    positiveListener: DialogInterface.OnClickListener? = null
) {
    AlertDialog.Builder(this).setTitle(title).setMessage(msg)
        .setPositiveButton(txtPositiveBtn, positiveListener)
        .create().show()
}