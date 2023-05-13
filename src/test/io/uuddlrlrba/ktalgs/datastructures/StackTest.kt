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
import kotlin.test.assertFailsWith
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class StackTest {
    @Test
    fun emptyTest() {
        val stack = Stack<Int>()
        assertEquals(0, stack.size)
        assertTrue(stack.isEmpty())
    }

    @Test
    fun exceptionTest() {
        assertFailsWith<NoSuchElementException> {
            val stack = Stack<Int>()
            stack.peek()
        }
    }

    @Test
    fun naiveTest() {
        val stack = Stack<Int>()
        for (i in 0..10) {
            stack.push(i)
        }
        for (i in 10 downTo 0) {
            assertEquals(i, stack.peek())
            assertEquals(i, stack.poll())
        }
        assertEquals(0, stack.size)
    }

    @Test
    fun naiveIteratorTest() {
        val stack = Stack<Int>()
        for (i in 0..10) {
            stack.push(i)
        }

        var k = 10
        for (i in stack) {
            assertEquals(i, k--)
        }
    }

    @Test
    fun naiveContainsTest() {
        val stack = Stack<Int>()
        for (i in 0..10) {
            stack.push(i)
        }

        for (i in 0..10) {
            assertTrue(stack.contains(i))
        }

        assertFalse(stack.contains(100))
        assertFalse(stack.contains(101))
        assertFalse(stack.contains(103))
    }
}
