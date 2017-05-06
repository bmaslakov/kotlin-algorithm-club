package io.uuddlrlrba.ktalgs.geometry.convexhull

import io.uuddlrlrba.ktalgs.geometry.Point
import org.junit.Assert
import org.junit.Test

class GiftWrappingTest {
    @Test
    fun test1() {
        val points = arrayOf(Point(1, 1), Point(2, 5), Point(3, 3), Point(5, 3), Point(3, 2), Point(2, 2))
        val hull = GiftWrapping.convexHull(points)
        Assert.assertEquals(sortedSetOf(Point(1, 1), Point(2, 5), Point(5, 3)), hull.toSortedSet())
    }

    @Test
    fun test2() {
        val points = arrayOf(Point(3, 2), Point(2, 5), Point(4, 5))
        val hull = GiftWrapping.convexHull(points)
        Assert.assertEquals(points.toSortedSet(), hull.toSortedSet())
    }

    @Test
    fun test3() {
        val points = arrayOf(Point(0, 3), Point(2, 2), Point(1, 1), Point(2, 1), Point(3, 0), Point(0, 0), Point(3, 3))
        val hull = GiftWrapping.convexHull(points)
        Assert.assertEquals(sortedSetOf(Point(0, 3), Point(3, 0), Point(0, 0), Point(3, 3)), hull.toSortedSet())
    }

    @Test(expected= IllegalArgumentException::class)
    fun exceptionTest1() {
        GiftWrapping.convexHull(arrayOf(Point(0, 0)))
    }

    @Test(expected= IllegalArgumentException::class)
    fun exceptionTest2() {
        GiftWrapping.convexHull(arrayOf(Point(0, 0), Point(1, 1)))
    }
}
