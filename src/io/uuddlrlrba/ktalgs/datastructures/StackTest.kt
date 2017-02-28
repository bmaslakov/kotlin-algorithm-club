package io.uuddlrlrba.ktalgs.datastructures

import org.junit.Assert
import org.junit.Test
import java.util.*

class StackTest {
    @Test
    public fun emptyTest() {
        val stack = Stack<Int>()
        Assert.assertEquals(0, stack.size)
    }

    @Test(expected=NoSuchElementException::class)
    public fun exceptionTest() {
        val stack = Stack<Int>()
        stack.peek()
    }

    @Test
    public fun naiveTest() {
        val stack = Stack<Int>()
        for (i in 0..10) {
            stack.push(i)
        }
        for (i in 10..0) {
            Assert.assertEquals(i, stack.peek())
            Assert.assertEquals(i, stack.poll())
        }
    }
}
