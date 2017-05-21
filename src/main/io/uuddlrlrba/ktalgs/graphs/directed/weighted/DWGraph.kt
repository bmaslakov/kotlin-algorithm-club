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

import io.uuddlrlrba.ktalgs.datastructures.Queue
import io.uuddlrlrba.ktalgs.datastructures.Stack
import io.uuddlrlrba.ktalgs.graphs.Graph

class DWGraph(public override val V: Int): Graph {
    public override var E: Int = 0
    private val adj: Array<Queue<Edge>> = Array(V) { Queue<Edge>() }
    private val indegree: IntArray = IntArray(V)

    public class Edge(public val from: Int, public val to: Int, public val weight: Double)

    public fun addEdge(from: Int, to: Int, weight: Double) {
        val edge = Edge(from, to, weight)
        adj[from].add(edge)
        indegree[to]++
        E++
    }

    public fun edges(): Collection<Edge> {
        val stack = Stack<Edge>()
        adj.flatMap { it }.forEach { stack.push(it) }
        return stack
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
