package org.parikshan.kmpmobile

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform