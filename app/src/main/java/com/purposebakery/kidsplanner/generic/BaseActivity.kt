package com.purposebakery.kidsplanner.generic

import android.annotation.SuppressLint
import android.content.ContextWrapper
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.pixplicity.easyprefs.library.Prefs

@SuppressLint("Registered")
abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Prefs.Builder()
            .setContext(this)
            .setMode(ContextWrapper.MODE_PRIVATE)
            .setPrefsName(getPackageName())
            .setUseDefaultSharedPreference(true)
            .build();
    }


}
