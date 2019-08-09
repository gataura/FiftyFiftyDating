package com.dreams.best.ui

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.content.ContextCompat
import com.dreams.best.EXTRA_TASK_URL
import com.dreams.best.R

class ChromeTabsAdtivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chrome_tabs_adtivity)

        val builder = CustomTabsIntent.Builder()
        builder.setToolbarColor(ContextCompat.getColor(this@ChromeTabsAdtivity, R.color.colorPrimary))
        builder.addDefaultShareMenuItem()
        builder.setShowTitle(false)
        builder.enableUrlBarHiding()
        val customTabsIntent = builder.build()
        customTabsIntent.launchUrl(this, Uri.parse(intent.getStringExtra(EXTRA_TASK_URL)))
    }
}
