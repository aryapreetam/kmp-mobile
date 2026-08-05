package org.parikshan.kmpmobile

import io.github.aryapreetam.parikshan.e2eTest
import kotlin.test.Test

class AppTest {

    @Test
    fun testClickMeShowsContent() = e2eTest {
        click("Click me!")
        assertVisible("Compose:")
    }
}
