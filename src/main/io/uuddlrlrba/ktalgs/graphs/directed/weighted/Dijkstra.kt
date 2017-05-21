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

package io.uuddlrlrba.ktalgs.graphs.directed.weighted

import io.uuddlrlrba.ktalgs.datastructures.IndexedPriorityQueue
import io.uuddlrlrba.ktalgs.datastructures.Stack
import io.uuddlrlrba.ktalgs.graphs.NoSuchPathException

class Dijkstra(graph: DWGraph, val from: Int) {
    /**
     * distTo[v] = distance  of shortest s->v path
     */
    private val distTo: DoubleArray = DoubleArray(graph.V, { if (it == from) 0.0 else Double.POSITIVE_INFINITY })

    /**
     * edgeTo[v] = last edge on shortest s->v path
     */
    private val edgeTo: Array<DWGraph.Edge?> = arrayOfNulls(graph.V)

    /**
     * priority queue of vertices
     */
    private val pq: IndexedPriorityQueue<Double> = IndexedPriorityQueue(graph.V)

    init {
        if (graph.edges().filter { it.weight < 0 }.isNotEmpty()) {
            throw IllegalArgumentException("there is a negative weight edge")
        }

        // relax vertices in order of distance from s
        pq.insert(from, distTo[from])
        while (!pq.isEmpty()) {
            val v = pq.poll().first
            for (e in graph.adjacentEdges(v)) {
                relax(e)
            }
        }
    }

    // relax edge e and update pq if changed
    private fun relax(e: DWGraph.Edge) {
        val v = e.from
        val w = e.to
        if (distTo[w] > distTo[v] + e.weight) {
            distTo[w] = distTo[v] + e.weight
            edgeTo[w] = e
            if (pq.contains(w)) {
                pq.decreaseKey(w, distTo[w])
            } else {
                pq.insert(w, distTo[w])
            }
        }
    }

    /**
     * Returns the length of a shortest path from the source vertex `s` to vertex `v`.
     * @param  v the destination vertex
     * @return the length of a shortest path from the source vertex `s` to vertex `v`;
     *         `Double.POSITIVE_INFINITY` if no such path
     */
    fun distTo(v: Int): Double {
        return distTo[v]
    }

    /**
     * Returns true if there is a path from the source vertex `s` to vertex `v`.
     * @param  v the destination vertex
     * @return `true` if there is a path from the source vertex
     *         `s` to vertex `v`; `false` otherwise
     */
    fun hasPathTo(v: Int): Boolean {
        return distTo[v] < java.lang.Double.POSITIVE_INFINITY
    }

    /**
     * Returns a shortest path from the source vertex `s` to vertex `v`.
     * @param  v the destination vertex
     * @return a shortest path from the source vertex `s` to vertex `v`
     *         as an iterable of edges, and `null` if no such path
     */
    fun pathTo(v: Int): Iterable<DWGraph.Edge> {
        if (!hasPathTo(v)) throw NoSuchPathException("There is no path from [$from] to [$v]")
        val path = Stack<DWGraph.Edge>()
        var e = edgeTo[v]
        while (e != null) {
            path.push(e)
            e = edgeTo[e.from]
        }
        return path
    }
}
