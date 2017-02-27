package im.uuddlrlrba.ktalgs.datastructures

import org.junit.Assert
import org.junit.Test
import java.util.*

class DequeueTest {
    @Test
    public fun emptyTest() {
        val dequeue = Dequeue<Int>()
        Assert.assertEquals(0, dequeue.size)
    }

    @Test(expected= NoSuchElementException::class)
    public fun exceptionTest() {
        val dequeue = Dequeue<Int>()
        dequeue.peekFirst()
    }

    @Test
    public fun naiveTest() {
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
}