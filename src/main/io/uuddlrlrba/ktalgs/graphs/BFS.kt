package io.uuddlrlrba.ktalgs.graphs

import io.uuddlrlrba.ktalgs.datastructures.Queue

class BFS {
    companion object Implementations {
        fun iterative(graph: Graph, levelorder: ((Int) -> Unit)? = null) {
            val visited = BooleanArray(graph.V)
            val queue = Queue<Int>()
            for (i in 0..graph.V - 1) {
                if (!visited[i]) {
                    queue.add(i)
                    visited[i] = true
                    levelorder?.invoke(i)
                    while (!queue.isEmpty()) {
                        val v = queue.poll()
                        for (w in graph.adjacentVertices(v)) {
                            if (!visited[w]) {
                                queue.add(w)
                                visited[w] = true
                                levelorder?.invoke(i)
                            }
                        }
                    }
                }
            }
        }
    }
}
