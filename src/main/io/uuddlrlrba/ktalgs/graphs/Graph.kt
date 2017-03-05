package io.uuddlrlrba.ktalgs.graphs

interface Graph {
    public val V: Int
    public var E: Int
    public fun adjacentVertices(from: Int): Collection<Int>
}