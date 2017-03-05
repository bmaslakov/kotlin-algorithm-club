package io.uuddlrlrba.ktalgs.graphs

import io.uuddlrlrba.ktalgs.datastructures.Stack

class DFS {
    companion object Implementations {
        fun iterative(graph: Graph, op: (Int) -> Unit) {
            val visited = BooleanArray(graph.V)
            val queue = Stack<Int>()
            for (i in 0..graph.V - 1) {
                if (!visited[i]) {
                    queue.push(i)
                    visited[i] = true
                    op(i)
                    while (!queue.isEmpty()) {
                        val v = queue.poll()
                        for (w in graph.adjacentVertices(v)) {
                            if (!visited[w]) {
                                queue.push(w)
                                visited[w] = true
                                op(i)
                            }
                        }
                    }
                }
            }
        }

        fun recursive(graph: Graph, op: (Int) -> Unit) {
            val visited = BooleanArray(graph.V)
            for (i in 0..graph.V - 1) {
                if (!visited[i]) {
                    dfs(i, graph, visited, op)
                }
            }
        }

        private fun dfs(v: Int, graph: Graph, visited: BooleanArray, op: (Int) -> Unit) {
            visited[v] = true
            op(v)
            for (w in graph.adjacentVertices(v)) {
                if (!visited[w]) {
                    dfs(w, graph, visited, op)
                }
            }
        }
    }
}