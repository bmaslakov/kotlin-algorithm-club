/*
 * Copyright (c) 2017 Kotlin Algorithm Club
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package io.uuddlrlrba.ktalgs.sorts

import org.junit.Assert
import org.junit.Test

abstract class AbstractSortTest<out T: AbstractSortStrategy>(val strategy: T) {
    @Test
    fun emptyTest() {
        val arr = arrayOf<Int>()
        strategy.perform(arr)
        Assert.assertArrayEquals(arrayOf<Int>(), arr)
    }

    @Test
    fun singletonTest() {
        val arr = arrayOf(1)
        strategy.perform(arr)
        Assert.assertArrayEquals(arrayOf(1), arr)
    }

    @Test
    fun twoElementsInOrderTest() {
        val arr = arrayOf(42, 43)
        strategy.perform(arr)
        Assert.assertArrayEquals(arrayOf(42, 43), arr)
    }

    @Test
    fun twoElementsOutOfOrderTest() {
        val arr = arrayOf(43, 42)
        strategy.perform(arr)
        Assert.assertArrayEquals(arrayOf(42, 43), arr)
    }

    @Test
    fun twoElementsEqualTest() {
        val arr = arrayOf(42, 42)
        strategy.perform(arr)
        Assert.assertArrayEquals(arrayOf(42, 42), arr)
    }

    @Test
    fun tenElementsReverseTest() {
        val arr = arrayOf(10, 9, 8, 7, 6, 5, 4, 3, 2, 1)
        strategy.perform(arr)
        Assert.assertArrayEquals(arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), arr)
    }

    @Test
    fun tenElementsTest() {
        val arr = arrayOf(3, 2, 7, 6, 1, 8, 10, 9, 4, 5)
        strategy.perform(arr)
        Assert.assertArrayEquals(arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), arr)
    }
}
