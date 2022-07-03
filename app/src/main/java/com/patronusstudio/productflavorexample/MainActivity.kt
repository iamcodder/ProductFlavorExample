package com.patronusstudio.productflavorexample

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val loginResultContract =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {
                val intent = Intent(this@MainActivity, ProfileActivity::class.java)
                startActivity(intent)
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginHelper: BaseLogin = LoginHelper(applicationContext)
        loginHelper.init()

        findViewById<View>(R.id.btn_login).setOnClickListener {
            loginResultContract.launch(loginHelper.getLoginIntent())
        }
    }

}