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

package io.uuddlrlrba.ktalgs.geometry

data class Point(val x: Int, val y: Int): Comparable<Point> {
    override fun compareTo(other: Point): Int {
        if (x == other.x) return y.compareTo(other.y)
        return x.compareTo(other.x)
    }

    fun isLeftOfLine(from: Point, to: Point): Boolean {
        return crossProduct(from, to) > 0
    }

    fun crossProduct(origin: Point, p2: Point): Int {
        return (p2.x - origin.x) * (this.y - origin.y) - (p2.y - origin.y) * (this.x - origin.x)
    }

    fun distanceToLine(a: Point, b: Point): Double {
        return Math.abs((b.x - a.x) * (a.y - this.y) - (a.x - this.x) * (b.y - a.y)) /
                Math.sqrt(Math.pow((b.x - a.x).toDouble(), 2.0) + Math.pow((b.y - a.y).toDouble(), 2.0))
    }

    fun euclideanDistanceTo(that: Point): Double {
        return EUCLIDEAN_DISTANCE_FUNC(this, that)
    }

    fun manhattanDistanceTo(that: Point): Double {
        return MANHATTAN_DISTANCE_FUNC(this, that)
    }

    companion object {
        // < 0 : Counterclockwise
        // = 0 : p, q and r are colinear
        // > 0 : Clockwise
        fun orientation(p: Point, q: Point, r: Point): Int {
            return (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y)
        }

        val EUCLIDEAN_DISTANCE_FUNC: (Point, Point) -> (Double) = { p, q ->
            val dx = p.x - q.x
            val dy = p.y - q.y
            Math.sqrt((dx * dx + dy * dy).toDouble())
        }

        val MANHATTAN_DISTANCE_FUNC: (Point, Point) -> (Double) = { p, q ->
            val dx = p.x - q.x
            val dy = p.y - q.y
            Math.sqrt((dx * dx + dy * dy).toDouble())
        }
    }
}