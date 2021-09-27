package com.example.iriscubeapp

import com.example.iriscubeapp.view.FirstFragment
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

private const val FAKE_STRING = "HELLO_WORLD"

class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test fun readStringFromContext_LocalizedString() {
        // Given a Context object retrieved from Robolectric...
        val myObjectUnderTest = FirstFragment()

        // ...when the string is returned from the object under test...
        val result: String = myObjectUnderTest.getHelloWordlString()
        // ...then the result should be the expected one.
        assertEquals(result, FAKE_STRING)
    }
}