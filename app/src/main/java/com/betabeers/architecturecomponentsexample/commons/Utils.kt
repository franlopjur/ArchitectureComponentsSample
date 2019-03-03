package com.betabeers.architecturecomponentsexample.commons

import android.support.annotation.StringRes

fun getString(@StringRes resourceId: Int): String {
    return CustomApplication.instance.getString(resourceId)
}