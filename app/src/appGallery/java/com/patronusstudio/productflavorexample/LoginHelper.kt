package com.patronusstudio.productflavorexample

import android.content.Context
import android.content.Intent
import com.huawei.agconnect.AGConnectInstance
import com.huawei.hms.support.account.AccountAuthManager
import com.huawei.hms.support.account.request.AccountAuthParams
import com.huawei.hms.support.account.request.AccountAuthParamsHelper
import com.huawei.hms.support.account.service.AccountAuthService

class LoginHelper(private val context: Context) : BaseLogin() {

    override fun init() {
        AGConnectInstance.initialize(context)
    }

    override fun getLoginIntent(): Intent {
        val authParams: AccountAuthParams =
            AccountAuthParamsHelper(AccountAuthParams.DEFAULT_AUTH_REQUEST_PARAM)
                .setProfile()
                .setEmail()
                .setAuthorizationCode().createParams()
        val service: AccountAuthService =
            AccountAuthManager.getService(context, authParams)
        return service.signInIntent
    }

}