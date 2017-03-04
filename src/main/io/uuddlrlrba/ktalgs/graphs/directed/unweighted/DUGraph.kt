package io.uuddlrlrba.ktalgs.graphs.directed.unweighted

import io.uuddlrlrba.ktalgs.datastructures.Queue

class DUGraph(public val V: Int) {
    public var E: Int = 0
        private set
    private val adj: Array<Queue<Int>> = Array(V) { Queue<Int>() }
    private val indegree: IntArray = IntArray(V)

    public fun addEdge(from: Int, to: Int) {
        adj[from].add(to)
        indegree[to]++
        E++
    }

    public fun adj(from: Int): Collection<Int> {
        return adj[from]
    }

    public fun outdegree(v: Int): Int {
        return adj[v].size
    }

    public fun indegree(v: Int): Int {
        return indegree[v]
    }
}
