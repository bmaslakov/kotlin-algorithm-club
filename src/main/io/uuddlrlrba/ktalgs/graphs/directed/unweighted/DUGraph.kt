package io.uuddlrlrba.ktalgs.graphs.directed.unweighted

import io.uuddlrlrba.ktalgs.datastructures.Queue
import io.uuddlrlrba.ktalgs.graphs.Graph

class DUGraph(public override val V: Int): Graph {
    override var E: Int = 0
    private val adj: Array<Queue<Int>> = Array(V) { Queue<Int>() }
    private val indegree: IntArray = IntArray(V)

    public fun addEdge(from: Int, to: Int) {
        adj[from].add(to)
        indegree[to]++
        E++
    }

    public override fun adjacentVertices(from: Int): Collection<Int> {
        return adj[from]
    }

    public fun outdegree(from: Int): Int {
        return adj[from].size
    }

    public fun indegree(v: Int): Int {
        return indegree[v]
    }
}
