package com.patronusstudio.productflavorexample

import android.content.Intent

abstract class BaseLogin {

    abstract fun init()

    abstract fun getLoginIntent(): Intent

}