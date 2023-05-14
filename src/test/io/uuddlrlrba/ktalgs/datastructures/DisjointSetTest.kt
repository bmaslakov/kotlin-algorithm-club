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

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class DisjointSetTest {
    @Test
    fun sizeTest() {
        val set = DisjointSet(10)
        assertEquals(10, set.count)
        assertEquals(10, set.size)
        set.union(0, 1)
        assertEquals(9, set.count)
        assertEquals(10, set.size)
        set.union(0, 2)
        assertEquals(8, set.count)
        assertEquals(10, set.size)
    }

    @Test
    fun naiveTest() {
        val set = DisjointSet(10)
        for (i in 1..set.size-1) {
            assertFalse(set.connected(i, i - 1))
        }
        set.union(1, 2)
        assertTrue(set.connected(1, 2))
        set.union(1, 3)
        assertTrue(set.connected(1, 3))
        assertTrue(set.connected(2, 3))
        set.union(3, 4)
        assertTrue(set.connected(2, 4))
        assertFalse(set.connected(0, 1))
        assertFalse(set.connected(0, 5))
        assertFalse(set.connected(4, 5))
    }
}