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
import io.uuddlrlrba.ktalgs.datastructures.Queue

class BoruvkaMST(G: UWGraph): MST {
    var weight: Double = 0.0
    var edges: Queue<UWGraph.Edge> = Queue()

    init {
        val uf = DisjointSet(G.V)

        // repeat at most log V times or until we have V-1 edges
        var t = 1
        while (t < G.V && edges.size < G.V - 1) {

            // foreach tree in forest, find closest edge
            // if edge weights are equal, ties are broken in favor of first edge in G.edges()
            val closest = arrayOfNulls<UWGraph.Edge>(G.V)
            for (e in G.edges()) {
                val v = e.v
                val w = e.w
                val i = uf.find(v)
                val j = uf.find(w)
                if (i == j) continue   // same tree
                if (closest[i] == null || e < closest[i]!!) closest[i] = e
                if (closest[j] == null || e < closest[j]!!) closest[j] = e
            }

            // add newly discovered edges to MST
            for (i in 0..G.V - 1) {
                val e = closest[i]
                if (e != null) {
                    val v = e.v
                    val w = e.w
                    // don't add the same edge twice
                    if (!uf.connected(v, w)) {
                        edges.add(e)
                        weight += e.weight
                        uf.union(v, w)
                    }
                }
            }
            t += t
        }
    }

    override fun edges(): Iterable<UWGraph.Edge> {
        return edges
    }

    override fun weight(): Double {
        return weight
    }
}
