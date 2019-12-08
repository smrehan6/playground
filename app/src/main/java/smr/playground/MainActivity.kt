package smr.playground

import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import smr.playground.base.BaseActivity
import smr.playground.welcome.WelcomeActivity

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnWelcome.setOnClickListener { startActivity(Intent(this, WelcomeActivity::class.java)) }
        btnDialog.setOnClickListener { showDialog("Hello Dialog!") }
        btnLaunchMode.setOnClickListener { TODO() }
    }

}
