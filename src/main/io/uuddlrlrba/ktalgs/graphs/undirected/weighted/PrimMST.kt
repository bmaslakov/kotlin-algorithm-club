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

import io.uuddlrlrba.ktalgs.datastructures.IndexedPriorityQueue
import io.uuddlrlrba.ktalgs.datastructures.Queue

class PrimMST(G: UWGraph): MST {
    var weight: Double = 0.0
    var edges: Queue<UWGraph.Edge> = Queue()

    /**
     * distTo[v] = distance  of shortest s->v path
     */
    private val distTo: DoubleArray = DoubleArray(G.V) { Double.POSITIVE_INFINITY }

    /**
     * edgeTo[v] = last edge on shortest s->v path
     */
    private val edgeTo: Array<UWGraph.Edge?> = arrayOfNulls(G.V)

    /**
     * priority queue of vertices
     */
    private val pq: IndexedPriorityQueue<Double> = IndexedPriorityQueue(G.V)

    private val visited = Array(G.V) { false }

    init {
        for (s in G.vertices()) {
            if (!visited[s]) {
                distTo[s] = 0.0
                pq.insert(s, 0.0)
                while (!pq.isEmpty()) {
                    val v = pq.poll().first
                    visited[v] = true
                    for (e in G.adjacentEdges(v)) {
                        scan(e, v)
                    }
                }
            }
        }

        for (v in edgeTo.indices) {
            val e = edgeTo[v]
            if (e != null) {
                edges.add(e)
                weight += e.weight
            }
        }
    }

    private fun scan(e: UWGraph.Edge, v: Int) {
        val w = e.other(v)
        if (!visited[w]) { // v-w is obsolete edge
            if (e.weight < distTo[w]) {
                distTo[w] = e.weight
                edgeTo[w] = e
                if (pq.contains(w)) {
                    pq.decreaseKey(w, distTo[w])
                } else {
                    pq.insert(w, distTo[w])
                }
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