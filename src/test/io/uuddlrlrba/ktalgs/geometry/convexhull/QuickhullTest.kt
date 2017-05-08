package io.uuddlrlrba.ktalgs.geometry.convexhull

import io.uuddlrlrba.ktalgs.geometry.Point
import org.junit.Assert
import org.junit.Test

class QuickhullTest {
    @Test
    fun test1() {
        val points = arrayOf(Point(1, 1), Point(2, 5), Point(3, 3), Point(5, 3), Point(3, 2), Point(2, 2))
        val hull = Quickhull.convexHull(points)
        Assert.assertEquals(sortedSetOf(Point(1, 1), Point(2, 5), Point(5, 3)), hull.toSortedSet())
    }

    @Test
    fun test2() {
        val points = arrayOf(Point(3, 2), Point(2, 5), Point(4, 5))
        val hull = Quickhull.convexHull(points)
        Assert.assertEquals(points.toSortedSet(), hull.toSortedSet())
    }

    @Test
    fun test3() {
        val points = arrayOf(Point(0, 3), Point(2, 2), Point(1, 1), Point(2, 1), Point(3, 0), Point(0, 0), Point(3, 3))
        val hull = Quickhull.convexHull(points)
        Assert.assertEquals(sortedSetOf(Point(0, 3), Point(3, 0), Point(0, 0), Point(3, 3)), hull.toSortedSet())
    }

    @Test
    fun test4() {
        val hullExpected = arrayOf(
            Point(10, 3),
            Point(8, 0),
            Point(2, 0),
            Point(0, 3),
            Point(2, 6),
            Point(8, 6)
        )

        val points = hullExpected + arrayOf(
            Point(3, 5),
            Point(3, 3),
            Point(6, 3),
            Point(6, 3),
            Point(7, 1),
            Point(8, 4)
        )
        val hull = Quickhull.convexHull(points)
        Assert.assertEquals(hullExpected.toSortedSet(), hull.toSortedSet())
    }

    @Test(expected= IllegalArgumentException::class)
    fun exceptionTest1() {
        Quickhull.convexHull(arrayOf(Point(0, 0)))
    }

    @Test(expected= IllegalArgumentException::class)
    fun exceptionTest2() {
        Quickhull.convexHull(arrayOf(Point(0, 0), Point(1, 1)))
    }
}
