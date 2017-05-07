package io.uuddlrlrba.ktalgs.geometry

data class Point(val x: Int, val y: Int): Comparable<Point> {
    override fun compareTo(other: Point): Int {
        if (x == other.x) return y.compareTo(other.y)
        return x.compareTo(other.x)
    }

    companion object {
        // < 0 : Counterclockwise
        // = 0 : p, q and r are colinear
        // > 0 : Clockwise
        fun orientation(p: Point, q: Point, r: Point): Int {
            return (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y)
        }
    }
}