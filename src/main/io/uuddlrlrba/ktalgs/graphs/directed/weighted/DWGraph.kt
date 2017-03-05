package io.uuddlrlrba.ktalgs.graphs.directed.weighted

import io.uuddlrlrba.ktalgs.datastructures.Queue
import io.uuddlrlrba.ktalgs.graphs.Graph

class DWGraph(public override val V: Int): Graph {
    public override var E: Int = 0
    private val adj: Array<Queue<Edge>> = Array(V) { Queue<Edge>() }
    private val indegree: IntArray = IntArray(V)

    public class Edge(public val from: Int, public val to: Int, public val weight: Number)

    public fun addEdge(from: Int, to: Int, weight: Number) {
        val edge = Edge(from, to, weight)
        adj[from].add(edge)
        indegree[to]++
        E++
    }

    public fun adjacentEdges(from: Int): Collection<Edge> {
        return adj[from]
    }

    public override fun adjacentVertices(from: Int): Collection<Int> {
        return adjacentEdges(from).map { it.to }
    }

    public fun outdegree(v: Int): Int {
        return adj[v].size
    }
}
