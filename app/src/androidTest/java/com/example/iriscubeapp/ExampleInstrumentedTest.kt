package com.example.iriscubeapp

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.iriscubeapp.view.FirstFragment

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

private const val FAKE_STRING = "HELLO_WORLD"

@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.iriscubeapp", appContext.packageName)
    }

    @Test fun readStringFromContext_LocalizedString() {
        // Given a Context object retrieved from Robolectric...
        val myObjectUnderTest = FirstFragment()

        // ...when the string is returned from the object under test...
        val result: String = myObjectUnderTest.getHelloWorldString()
        // ...then the result should be the expected one.
        assertEquals(result, FAKE_STRING)
    }

}