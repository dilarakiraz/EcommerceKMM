package org.dilarakiraz.composempnotes

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "EcommerceKMM",
    ) {
        App()
    }
}