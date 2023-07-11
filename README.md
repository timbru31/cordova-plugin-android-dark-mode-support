# cordova-plugin-android-dark-mode-support

[![Linting](https://github.com/timbru31/cordova-plugin-android-dark-mode-support/workflows/Linting/badge.svg)](https://github.com/timbru31/cordova-plugin-android-dark-mode-support/actions?query=workflow%3ALinting)
[![npm audit](https://github.com/timbru31/cordova-plugin-android-dark-mode-support/workflows/Security/badge.svg)](https://github.com/timbru31/cordova-plugin-android-dark-mode-support/actions?query=workflow%3ASecurity)

[![Known Vulnerabilities](https://snyk.io/test/github/timbru31/cordova-plugin-android-dark-mode-support/badge.svg)](https://snyk.io/test/github/timbru31/cordova-plugin-android-dark-mode-support)

[![Commitizen friendly](https://img.shields.io/badge/commitizen-friendly-brightgreen.svg)](https://commitizen.github.io/cz-cli/)
[![License](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)
[![npm](https://img.shields.io/npm/v/cordova-plugin-android-dark-mode-support.svg)](https://www.npmjs.com/package/cordova-plugin-android-dark-mode-support)

#### Apache Cordova plugin to enable proper dark mode support for Android WebView's

### Context/Background

While Android supports a dark mode since API level 29 (Android 10), Android WebView's need explicit support for this.
This plugin changes the used Cordova WebView, no matter if the default from cordova-android or a custom one such as the cordova-plugin-ionic-webview to enable or disable the dark mode. This results in a correct usage of the `(prefers-color-scheme: dark)` media query.

Additionally, when the native configuration changes, it is re-evaluated whether the dark mode is currently active.

Under the hood, the `Configuration.UI_MODE_NIGHT_YES`, `WebSettingsCompat.setForceDark` and `WebSettingsCompat.setForceDarkStrategy` are used. You can read more here: https://developer.android.com/guide/webapps/dark-theme

#### Attention for SDK >= 33 / Android 13

In Android 13 (SDK 33) you do not this plugin anymore as the behavior was changed [[again](https://developer.android.com/about/versions/13/behavior-changes-13). All you need to do is tweak the used theme by setting:
```xml
        <preference name="AndroidPostSplashScreenTheme" value="@style/Theme.AppCompat.DayNight.NoActionBar" />
```

### Supported platforms

-   **Android**

#### Prerequisites/Warnings

Kotlin support is required. Due to the AndroidX support libraries used, only **cordova-android >= 11.0.0** is supported.  
You need to enable Kotlin `config.xml` by setting `GradlePluginKotlinEnabled` to `true`.

### Installation

#### from npm (recommended)

`$ cordova plugin add cordova-plugin-android-dark-mode-support`

#### from git (unstable)

`$ cordova plugin add https://github.com/timbru31/cordova-plugin-android-dark-mode-support.git`

### Usage

Just install the plugin. Initially it will check the dark mode settings of the device and update once a new configuration is received.  
For a instance a timed/schedule theme change can issue a new configuration.

---

Built by (c) Tim Brust and contributors. Released under the MIT license.
