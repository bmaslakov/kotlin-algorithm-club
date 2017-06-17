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

import io.uuddlrlrba.ktalgs.datastructures.Queue
import io.uuddlrlrba.ktalgs.graphs.Graph

class UWGraph(public override val V: Int): Graph {
    public override var E: Int = 0
    private val adj: Array<Queue<Edge>> = Array(V) { Queue<Edge>() }

    public class Edge(public val v: Int, public val w: Int, public val weight: Double): Comparable<Edge> {
        override fun compareTo(other: Edge): Int {
            return this.weight.compareTo(other.weight)
        }

        fun other(s: Int): Int {
            if (s == v) return w
            if (s == w) return v
            throw IllegalArgumentException()
        }
    }

    public fun addEdge(v: Int, w: Int, weight: Double) {
        val edge = Edge(v, w, weight)
        adj[v].add(edge)
        adj[w].add(edge)
        E++
    }

    public fun adjacentEdges(v: Int): Collection<Edge> {
        return adj[v]
    }

    public override fun adjacentVertices(v: Int): Collection<Int> {
        return adjacentEdges(v).map { it.other(v) }
    }

    public fun degree(v: Int): Int {
        return adj[v].size
    }

    public fun edges(): Collection<Edge> {
        return adj.flatMap { it }
    }
}
