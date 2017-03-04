package io.uuddlrlrba.ktalgs.graphs.directed.weighted

import io.uuddlrlrba.ktalgs.datastructures.Queue

class DWGraph(private val V: Int) {
    public var E: Int = 0
        private set
    public val adj: Array<Queue<Edge>> = Array(V) { Queue<Edge>() }
    private val indegree: Array<Int> = Array(V) { return@Array 0 }

    public class Edge(public val from: Int, public val to: Int, public val weight: Number)

    public fun addEdge(from: Int, to: Int, weight: Number) {
        val edge = Edge(from, to, weight)
        adj[from].add(edge)
        indegree[to]++
        E++
    }

    public fun adj(v: Int): Collection<Edge> {
        return adj[v]
    }

    public fun outdegree(v: Int): Int {
        return adj[v].size
    }
}
