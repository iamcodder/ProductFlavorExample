package com.patronusstudio.productflavorexample

import android.content.Context
import android.content.Intent

class LoginHelper(private val context: Context) : BaseLogin() {

    override fun init() {
    }

    override fun getLoginIntent(): Intent {
        return Intent()
    }

}