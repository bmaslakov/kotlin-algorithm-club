package io.uuddlrlrba.ktalgs.datastructures

import org.junit.Assert
import org.junit.Test
import java.util.*

class QueueTest {
    @Test
    public fun emptyTest() {
        val queue = Queue<Int>()
        Assert.assertEquals(0, queue.size)
    }

    @Test(expected= NoSuchElementException::class)
    public fun exceptionTest() {
        val queue = Queue<Int>()
        queue.peek()
    }

    @Test
    public fun naiveTest() {
        val queue = Queue<Int>()
        for (i in 0..10) {
            queue.add(i)
        }
        for (i in 0..10) {
            Assert.assertEquals(i, queue.peek())
            Assert.assertEquals(i, queue.poll())
        }
    }
}
