package org.dilarakiraz.composempnotes

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform