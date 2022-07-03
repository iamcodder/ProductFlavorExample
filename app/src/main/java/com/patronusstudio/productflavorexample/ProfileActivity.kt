package com.patronusstudio.productflavorexample

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.huawei.hms.support.account.AccountAuthManager
import com.huawei.hms.support.account.request.AccountAuthParams
import com.huawei.hms.support.account.request.AccountAuthParamsHelper
import com.huawei.hms.support.account.service.AccountAuthService

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val authParams: AccountAuthParams =
            AccountAuthParamsHelper(AccountAuthParams.DEFAULT_AUTH_REQUEST_PARAM)
                .setProfile()
                .setEmail()
                .setAuthorizationCode().createParams()
        val service: AccountAuthService =
            AccountAuthManager.getService(this, authParams)
        findViewById<Button>(R.id.username).setOnClickListener {
            signOutWithForgotMe(service)
        }

    }

    private fun signOutWithForgotMe(service: AccountAuthService) {
        service.cancelAuthorization().addOnSuccessListener {
            it
            finish()
        }.addOnFailureListener {
            it
        }
    }
}