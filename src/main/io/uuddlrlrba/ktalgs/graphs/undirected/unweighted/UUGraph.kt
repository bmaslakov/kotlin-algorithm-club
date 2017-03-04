package io.uuddlrlrba.ktalgs.graphs.undirected.unweighted

import io.uuddlrlrba.ktalgs.datastructures.Queue

class UUGraph(private val V: Int) {
    public var E: Int = 0
        private set
    public val adj: Array<Queue<Int>> = Array(V) { Queue<Int>() }

    public fun addEdge(v: Int, w: Int) {
        adj[v].add(w)
        adj[w].add(v)
        E++
    }

    public fun adj(v: Int): Collection<Int> {
        return adj[v]
    }

    public fun degree(v: Int): Int {
        return adj[v].size
    }
}
