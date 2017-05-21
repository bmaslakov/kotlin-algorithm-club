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

package io.uuddlrlrba.ktalgs.graphs

import io.uuddlrlrba.ktalgs.datastructures.Stack

class DFS {
    companion object Implementations {
        fun iterative(graph: Graph,
                      preorder: ((Int) -> Unit)? = null,
                      postorder: ((Int) -> Unit)? = null) {
            val visited = IntArray(graph.V)
            val queue = Stack<Int>()
            for (i in 0..graph.V - 1) {
                if (visited[i] == 0) {
                    queue.push(i)
                    visited[i] = 1
                    while (!queue.isEmpty()) {
                        val v = queue.poll()
                        if (visited[v] == 1) {
                            visited[i] = 2
                            preorder?.invoke(i)
                            queue.push(v)
                            for (w in graph.adjacentVertices(v)) {
                                if (visited[w] == 0) {
                                    queue.push(w)
                                    visited[w] = 1
                                }
                            }
                        } else {
                            visited[i] = 3
                            postorder?.invoke(i)
                        }
                    }
                }
            }
        }

        fun recursive(graph: Graph,
                      preorder: ((Int) -> Unit)? = null,
                      postorder: ((Int) -> Unit)? = null) {
            val visited = BooleanArray(graph.V)
            for (i in 0..graph.V - 1) {
                if (!visited[i]) {
                    dfs(i, graph, visited, preorder, postorder)
                }
            }
        }

        private fun dfs(v: Int, graph: Graph, visited: BooleanArray,
                        preorder: ((Int) -> Unit)? = null,
                        postorder: ((Int) -> Unit)? = null) {
            visited[v] = true
            preorder?.invoke(v)
            for (w in graph.adjacentVertices(v)) {
                if (!visited[w]) {
                    dfs(w, graph, visited, preorder, postorder)
                }
            }
            postorder?.invoke(v)
        }
    }
}