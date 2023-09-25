package de.dustplanet.cordova

import android.content.res.Configuration
import android.os.Build
import androidx.webkit.WebSettingsCompat
import androidx.webkit.WebViewFeature
import org.apache.cordova.CordovaPlugin
import org.apache.cordova.engine.SystemWebView

class AndroidDarkModeSupport : CordovaPlugin() {
    override fun pluginInitialize() {
        checkDarkMode()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        checkDarkMode()
    }

    private fun checkDarkMode() {
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.S_V2) {
            val nightMode: Boolean =
                cordova.context.resources.configuration.uiMode and
                    Configuration.UI_MODE_NIGHT_MASK == Configuration.UI_MODE_NIGHT_YES
            val view = (webView.engine.view as SystemWebView).settings

            if (WebViewFeature.isFeatureSupported(WebViewFeature.FORCE_DARK)) {
                WebSettingsCompat.setForceDark(
                    view,
                    when {
                        nightMode -> WebSettingsCompat.FORCE_DARK_ON
                        else -> WebSettingsCompat.FORCE_DARK_OFF
                    },
                )
            }

            if (WebViewFeature.isFeatureSupported(WebViewFeature.FORCE_DARK_STRATEGY)) {
                WebSettingsCompat.setForceDarkStrategy(
                    view,
                    WebSettingsCompat.DARK_STRATEGY_WEB_THEME_DARKENING_ONLY,
                )
            }
        }
    }
}
