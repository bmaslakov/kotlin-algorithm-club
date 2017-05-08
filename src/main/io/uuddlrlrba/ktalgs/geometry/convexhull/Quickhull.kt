package io.uuddlrlrba.ktalgs.geometry.convexhull

import io.uuddlrlrba.ktalgs.datastructures.Stack
import io.uuddlrlrba.ktalgs.geometry.Point

object Quickhull {
    fun convexHull(points: Array<Point>): Collection<Point> {
        if (points.size < 3) {
            throw IllegalArgumentException("there must be at least 3 points")
        }

        val hull = Stack<Point>()

        // Find the leftmost point
        val left = points.min()!!
        val right = points.max()!!

        // add left half
        for (point in quickHull(points.asList(), left, right)) {
            hull.push(point)
        }

        // add right half
        for (point in quickHull(points.asList(), right, left)) {
            hull.push(point)
        }

        return hull
    }

    private fun quickHull(points: Collection<Point>, first: Point, second: Point): Collection<Point> {
        val pointsLeftOfLine = points
                .filter { it.isLeftOfLine(first, second) }
                .map { Pair(it, it.distanceToLine(first, second)) }

        val hull = Stack<Point>()

        if (pointsLeftOfLine.isEmpty()) {
            hull.push(second)
        } else {
            val max = pointsLeftOfLine.maxBy { it.second }!!.first

            val newPoints = Stack<Point>()
            for (pd in pointsLeftOfLine) {
                newPoints.push(pd.first)
            }

            for (point in quickHull(newPoints, first, max)) {
                hull.push(point)
            }
            for (point in quickHull(newPoints, max, second)) {
                hull.push(point)
            }
        }

        return hull
    }
}
