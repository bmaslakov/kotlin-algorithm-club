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

package io.uuddlrlrba.ktalgs.datastructures

import org.junit.Assert
import org.junit.Test

class ImmutableSetTest {
    @Test
    fun test1() {
        Assert.assertFalse(immutableSetOf(3).contains(1))
        Assert.assertFalse(immutableSetOf(3).contains(2))
        Assert.assertFalse(immutableSetOf(3).contains(4))
        Assert.assertFalse(immutableSetOf(3).contains(5))
        Assert.assertTrue(immutableSetOf(3).contains(3))
    }

    @Test
    fun test2() {
        val set = immutableSetOf(*(10 downTo 1).toList().toTypedArray())
        for (v in set) {
            Assert.assertTrue(set.contains(v))
        }
        Assert.assertEquals(10, set.size)
        Assert.assertFalse(set.isEmpty())
        Assert.assertFalse(set.contains(42))
        Assert.assertFalse(set.contains(-42))
    }

    @Test
    fun test3() {
        val set = immutableSetOf(*(0..100).toList().toTypedArray())
        for (v in -100..-1) {
            Assert.assertFalse(set.contains(v))
        }
        for (v in 0..100) {
            Assert.assertTrue(set.contains(v))
        }
        for (v in 101..200) {
            Assert.assertFalse(set.contains(v))
        }
    }
}
