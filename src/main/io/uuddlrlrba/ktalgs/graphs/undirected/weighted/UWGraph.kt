package io.uuddlrlrba.ktalgs.graphs.undirected.weighted

import io.uuddlrlrba.ktalgs.datastructures.Queue

class UWGraph(private val V: Int) {
    public var E: Int = 0
        private set
    public val adj: Array<Queue<Edge>> = Array(V) { Queue<Edge>() }

    public class Edge(public val v: Int, public val w: Int, public val weight: Number) {
        fun other(s: Int): Int {
            if (s == v) return w
            if (s == w) return v
            throw IllegalArgumentException()
        }
    }

    public fun addEdge(v: Int, w: Int, weight: Number) {
        val edge = Edge(v, w, weight)
        adj[v].add(edge)
        adj[w].add(edge)
        E++
    }

    public fun adj(v: Int): Collection<Edge> {
        return adj[v]
    }

    public fun degree(v: Int): Int {
        return adj[v].size
    }
}
