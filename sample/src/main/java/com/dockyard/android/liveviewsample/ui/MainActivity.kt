package com.dockyard.android.liveviewsample.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import org.phoenixframework.liveview.addons.LiveViewJetpackAddons
import org.phoenixframework.liveview.addons.constants.AddonsTypes
import org.phoenixframework.liveview.liveform.LiveForm
import org.phoenixframework.liveview.ui.phx_components.LiveView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LiveViewJetpackAddons.run {
            registerComponentByTag(
                AddonsTypes.asyncImage,
                AddonsTypes.annotatedText
            )
        }
        LiveForm.registerComponents()
        setContent {
            // Points to the thermostat example from the core library tests.
            // Change this URL to point at your local LVN app.
            LiveView(url = "http://192.168.0.165:4000/home")
        }
    }
}