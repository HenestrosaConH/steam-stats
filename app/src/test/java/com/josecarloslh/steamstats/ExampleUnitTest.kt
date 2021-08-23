package com.josecarloslh.steamstats

import org.junit.Assert
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        val FORMAT_DISCOUNT_PERCENTAGE = "%.0f%%"
        fun formatPercentage(percentage: Float) = String.format(FORMAT_DISCOUNT_PERCENTAGE, percentage)
        formatPercentage(90.128755F)
        Assert.assertEquals("90%", formatPercentage(90.128755F))
    }
}