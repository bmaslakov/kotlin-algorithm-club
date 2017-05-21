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

class DequeueTest {
    @Test
    fun emptyTest() {
        val dequeue = Dequeue<Int>()
        Assert.assertEquals(0, dequeue.size)
        Assert.assertTrue(dequeue.isEmpty())
    }

    @Test(expected= NoSuchElementException::class)
    fun exceptionTest() {
        val dequeue = Dequeue<Int>()
        dequeue.peekFirst()
    }

    @Test
    fun naiveTest() {
        val dequeue = Dequeue<Int>()
        for (i in 0..10) {
            dequeue.add(i)
        }
        for (i in 0..5) {
            Assert.assertEquals(i, dequeue.peekFirst())
            Assert.assertEquals(i, dequeue.pollFirst())
        }
        for (i in 10..6) {
            Assert.assertEquals(i, dequeue.peekLast())
            Assert.assertEquals(i, dequeue.pollLast())
        }
    }

    @Test
    fun naiveIteratorTest() {
        val dequeue = Dequeue<Int>()
        for (i in 0..10) {
            dequeue.add(i)
        }

        var k = 0
        for (i in dequeue) {
            Assert.assertEquals(i, k++)
        }
    }

    @Test
    fun naiveContainsTest() {
        val dequeue = Dequeue<Int>()
        for (i in 0..10) {
            dequeue.add(i)
        }

        for (i in 0..10) {
            Assert.assertTrue(dequeue.contains(i))
        }

        Assert.assertFalse(dequeue.contains(100))
        Assert.assertFalse(dequeue.contains(101))
        Assert.assertFalse(dequeue.contains(103))
    }
}