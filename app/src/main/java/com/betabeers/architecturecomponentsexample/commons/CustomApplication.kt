package com.betabeers.architecturecomponentsexample.commons

import android.app.Application
import android.content.Context
import com.betabeers.architecturecomponentsexample.api.ApiService
import java.lang.ref.WeakReference

class CustomApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        setContext(this)
        ApiService.getInstance()
    }

    companion object {
        private var sInstance: WeakReference<Context>? = null

        val instance: Context
            get() = sInstance?.get()!!

        private fun setContext(context: Context) {
            sInstance = WeakReference(context)
        }
    }
}