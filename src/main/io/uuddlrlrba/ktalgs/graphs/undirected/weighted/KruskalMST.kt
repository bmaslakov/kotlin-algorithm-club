package io.uuddlrlrba.ktalgs.graphs.undirected.weighted

import io.uuddlrlrba.ktalgs.datastructures.DisjointSet
import io.uuddlrlrba.ktalgs.datastructures.PriorityQueue
import io.uuddlrlrba.ktalgs.datastructures.Queue

/**
 * Kruskal's algorithm will grow a solution from the cheapest edge by adding the next cheapest edge,
 * provided that it doesn't create a cycle.
 */
class KruskalMST(G: UWGraph) {
    var weight: Double = 0.0
    var edges: Queue<UWGraph.Edge> = Queue()

    /**
     * Compute a minimum spanning tree (or forest) of an edge-weighted graph.
     * @param G the edge-weighted graph
     */
    init {
        val pq = PriorityQueue<UWGraph.Edge>(G.V, compareBy({ it.weight }))
        for (v in G.vertices()) {
            for (e in G.adjacentEdges(v)) {
                pq.add(e)
            }
        }

        val set = DisjointSet(G.V)
        while (!pq.isEmpty()) {
            val edge = pq.poll()
            if (!set.connected(edge.v, edge.w)) {
                edges.add(edge)
                set.union(edge.v, edge.w)
                weight += edge.weight
            }
        }
    }

    /**
     * Returns the edges in a minimum spanning tree (or forest).
     * @return the edges in a minimum spanning tree (or forest) as
     * *    an iterable of edges
     */
    fun edges(): Iterable<UWGraph.Edge> {
        return edges
    }

    /**
     * Returns the sum of the edge weights in a minimum spanning tree (or forest).
     * @return the sum of the edge weights in a minimum spanning tree (or forest)
     */
    fun weight(): Double {
        return weight
    }
}