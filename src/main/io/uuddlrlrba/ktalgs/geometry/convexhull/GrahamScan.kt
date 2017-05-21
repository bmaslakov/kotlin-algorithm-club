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

import io.uuddlrlrba.ktalgs.datastructures.Stack
import io.uuddlrlrba.ktalgs.geometry.Point

class GrahamScan: ConvexHullAlgorithm {
    override fun convexHull(points: Array<Point>): Collection<Point> {
        if (points.size < 3) throw IllegalArgumentException("there must be at least 3 points")

        val hull = Stack<Point>()

        // Find the leftmost point
        points.sortBy { it.y }

        // Sort points by polar angle with p
        points.sortWith( Comparator { q1, q2 ->
            val dx1 = q1.x - points[0].x
            val dy1 = q1.y - points[0].y
            val dx2 = q2.x - points[0].x
            val dy2 = q2.y - points[0].y

            if (dy1 >= 0 && dy2 < 0)
                -1    // q1 above; q2 below
            else if (dy2 >= 0 && dy1 < 0)
                +1    // q1 below; q2 above
            else if (dy1 == 0 && dy2 == 0) {            // 3-collinear and horizontal
                if (dx1 >= 0 && dx2 < 0)
                    -1
                else if (dx2 >= 0 && dx1 < 0)
                    +1
                else
                    0
            } else
                -Point.orientation(points[0], q1, q2)     // both above or below
            // Note: ccw() recomputes dx1, dy1, dx2, and dy2
        })

        hull.push(points[0])
        hull.push(points[1])

        for (i in IntRange(2, points.size - 1)) {
            var top = hull.poll()
            while (Point.orientation(hull.peek(), top, points[i]) <= 0) {
                top = hull.poll()
            }
            hull.push(top)
            hull.push(points[i])
        }

        return hull
    }
}
