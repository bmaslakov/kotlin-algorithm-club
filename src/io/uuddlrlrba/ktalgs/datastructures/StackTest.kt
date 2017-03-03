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
}
