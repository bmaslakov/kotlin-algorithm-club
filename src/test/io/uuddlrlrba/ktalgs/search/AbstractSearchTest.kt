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

package io.uuddlrlrba.ktalgs.search

import kotlin.test.Test
import kotlin.test.assertEquals

abstract class AbstractSearchTest<out T: AbstractSearchStrategy<Int>>(val strategy: T) {
    @Test
    fun emptyTest() {
        assertEquals(-1, strategy.perform(emptyArray(), 1))
    }

    @Test
    fun singletonTest() {
        assertEquals(0, strategy.perform(arrayOf(1), 1))
        assertEquals(-1, strategy.perform(arrayOf(1), 2))
    }

    @Test
    fun twoElementsTest() {
        assertEquals(0, strategy.perform(arrayOf(1, 2), 1))
        assertEquals(1, strategy.perform(arrayOf(1, 2), 2))
        assertEquals(-1, strategy.perform(arrayOf(1, 2), 3))
    }

    @Test
    fun tenElementsTest() {
        assertEquals(0, strategy.perform(arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 1))
        assertEquals(1, strategy.perform(arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 2))
        assertEquals(2, strategy.perform(arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 3))
        assertEquals(3, strategy.perform(arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 4))
        assertEquals(4, strategy.perform(arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 5))
        assertEquals(5, strategy.perform(arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 6))
        assertEquals(6, strategy.perform(arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 7))
        assertEquals(7, strategy.perform(arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 8))
        assertEquals(8, strategy.perform(arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 9))
        assertEquals(9, strategy.perform(arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 10))
        assertEquals(-1, strategy.perform(arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 0))
        assertEquals(-1, strategy.perform(arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 11))
    }
}
