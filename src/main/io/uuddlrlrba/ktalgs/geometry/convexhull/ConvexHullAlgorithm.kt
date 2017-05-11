package io.uuddlrlrba.ktalgs.geometry.convexhull

import io.uuddlrlrba.ktalgs.geometry.Point

interface ConvexHullAlgorithm {
    fun convexHull(points: Array<Point>): Collection<Point>
}
