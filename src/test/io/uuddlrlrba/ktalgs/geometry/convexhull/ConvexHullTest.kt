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

package io.uuddlrlrba.ktalgs.geometry.convexhull

import io.uuddlrlrba.ktalgs.geometry.Point
import org.junit.Assert
import org.junit.Test

abstract class ConvexHullTest(val strategy: ConvexHullAlgorithm) {
    @Test
    fun test1() {
        val points = arrayOf(
                Point(1, 1),
                Point(2, 5),
                Point(3, 3),
                Point(5, 3),
                Point(3, 2),
                Point(2, 2)
        )
        val expected = sortedSetOf(
                Point(1, 1),
                Point(2, 5),
                Point(5, 3)
        )
        val hull = strategy.convexHull(points)
        Assert.assertEquals(expected, hull.toSortedSet())
    }

    @Test
    fun test2() {
        val points = arrayOf(
                Point(3, 2),
                Point(2, 5),
                Point(4, 5)
        )
        val expected = points.toSortedSet()
        val hull = strategy.convexHull(points)
        Assert.assertEquals(expected, hull.toSortedSet())
    }

    @Test
    fun test3() {
        val points = arrayOf(
                Point(0, 3),
                Point(2, 2),
                Point(1, 1),
                Point(2, 1),
                Point(3, 0),
                Point(0, 0),
                Point(3, 3)
        )
        val expected = sortedSetOf(
                Point(0, 3),
                Point(3, 0),
                Point(0, 0),
                Point(3, 3)
        )
        val hull = strategy.convexHull(points)
        Assert.assertEquals(expected, hull.toSortedSet())
    }

    @Test
    fun test4() {
        val expected = arrayOf(
                Point(10, 3),
                Point(8, 0),
                Point(2, 0),
                Point(0, 3),
                Point(2, 6),
                Point(8, 6)
        )
        val points = expected + arrayOf(
                Point(3, 5),
                Point(3, 3),
                Point(6, 3),
                Point(6, 3),
                Point(7, 1),
                Point(8, 4)
        )
        val hull = strategy.convexHull(points)
        Assert.assertEquals(expected.toSortedSet(), hull.toSortedSet())
    }

    @Test(expected= IllegalArgumentException::class)
    fun exceptionTest0() {
        strategy.convexHull(emptyArray())
    }

    @Test(expected= IllegalArgumentException::class)
    fun exceptionTest1() {
        strategy.convexHull(arrayOf(Point(0, 0)))
    }

    @Test(expected= IllegalArgumentException::class)
    fun exceptionTest2() {
        strategy.convexHull(arrayOf(Point(0, 0), Point(1, 1)))
    }
}