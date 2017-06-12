/*
 * Copyright (c) 2017 Kotlin Algorithm Club
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package io.uuddlrlrba.ktalgs.graphs.undirected.weighted

import io.uuddlrlrba.ktalgs.datastructures.DisjointSet
import io.uuddlrlrba.ktalgs.datastructures.PriorityQueue
import io.uuddlrlrba.ktalgs.datastructures.Queue

/**
 * Kruskal's algorithm will grow a solution from the cheapest edge by adding the next cheapest edge,
 * provided that it doesn't create a cycle.
 */
class KruskalMST(G: UWGraph): MST {
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

    override fun edges(): Iterable<UWGraph.Edge> {
        return edges
    }

    override fun weight(): Double {
        return weight
    }
}