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

class Quickhull: ConvexHullAlgorithm {
    override fun convexHull(points: Array<Point>): Collection<Point> {
        if (points.size < 3) throw IllegalArgumentException("there must be at least 3 points")
        val left = points.min()!!
        val right = points.max()!!
        return quickHull(points.asList(), left, right) + quickHull(points.asList(), right, left)
    }

    private fun quickHull(points: Collection<Point>, first: Point, second: Point): Collection<Point> {
        val pointsLeftOfLine = points
                .filter { it.isLeftOfLine(first, second) }
                .map { Pair(it, it.distanceToLine(first, second)) }
        if (pointsLeftOfLine.isEmpty()) {
            return listOf(second)
        } else {
            val max = pointsLeftOfLine.maxBy { it.second }!!.first
            val newPoints = pointsLeftOfLine.map { it.first }
            return quickHull(newPoints, first, max) + quickHull(newPoints, max, second)
        }
    }
}
