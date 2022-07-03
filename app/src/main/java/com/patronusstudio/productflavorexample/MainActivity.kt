package com.patronusstudio.productflavorexample

import android.content.Intent
import android.os.Bundle
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import com.huawei.agconnect.AGConnectInstance
import com.huawei.hms.support.account.AccountAuthManager
import com.huawei.hms.support.account.request.AccountAuthParams
import com.huawei.hms.support.account.request.AccountAuthParamsHelper
import com.huawei.hms.support.account.service.AccountAuthService

enum class LoginType(val resultCode: Int) {
    HUAWEI(11),
    GOOGLE(22);
}


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        AGConnectInstance.initialize(applicationContext)

        findViewById<RelativeLayout>(R.id.btn_login).setOnClickListener {
            val authParams: AccountAuthParams =
                AccountAuthParamsHelper(AccountAuthParams.DEFAULT_AUTH_REQUEST_PARAM)
                    .setProfile()
                    .setEmail()
                    .setAuthorizationCode().createParams()
            val service: AccountAuthService =
                AccountAuthManager.getService(this@MainActivity, authParams)

            startActivityForResult(service.signInIntent, LoginType.HUAWEI.resultCode)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == LoginType.HUAWEI.resultCode) {
            val intent = Intent(this.applicationContext, ProfileActivity::class.java)
            startActivity(intent)
        }
    }
}