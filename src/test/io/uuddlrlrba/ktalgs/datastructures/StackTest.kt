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
import java.util.*

class StackTest {
    @Test
    fun emptyTest() {
        val stack = Stack<Int>()
        Assert.assertEquals(0, stack.size)
        Assert.assertTrue(stack.isEmpty())
    }

    @Test(expected=NoSuchElementException::class)
    fun exceptionTest() {
        val stack = Stack<Int>()
        stack.peek()
    }

    @Test
    fun naiveTest() {
        val stack = Stack<Int>()
        for (i in 0..10) {
            stack.push(i)
        }
        for (i in 10..0) {
            Assert.assertEquals(i, stack.peek())
            Assert.assertEquals(i, stack.poll())
        }
    }

    @Test
    fun naiveIteratorTest() {
        val stack = Stack<Int>()
        for (i in 0..10) {
            stack.push(i)
        }

        var k = 10
        for (i in stack) {
            Assert.assertEquals(i, k--)
        }
    }

    @Test
    fun naiveContainsTest() {
        val stack = Stack<Int>()
        for (i in 0..10) {
            stack.push(i)
        }

        for (i in 0..10) {
            Assert.assertTrue(stack.contains(i))
        }

        Assert.assertFalse(stack.contains(100))
        Assert.assertFalse(stack.contains(101))
        Assert.assertFalse(stack.contains(103))
    }
}
