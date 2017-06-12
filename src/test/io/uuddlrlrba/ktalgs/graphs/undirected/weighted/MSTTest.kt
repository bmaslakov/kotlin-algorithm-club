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

import org.junit.Assert
import org.junit.Test
import java.net.URL
import java.util.*

abstract class MSTTest(val strategy: (UWGraph) -> (MST)) {
    @Test
    fun test1() {
        val graph = UWGraph(4)
        graph.addEdge(0, 1, 4.0)
        graph.addEdge(1, 2, 1.0)
        graph.addEdge(2, 3, 2.0)
        graph.addEdge(0, 3, 5.0)
        graph.addEdge(0, 1, 4.0)
        graph.addEdge(1, 3, 3.0)
        val mst = strategy(graph)
        Assert.assertEquals(7.0, mst.weight(), 1e-12)
    }

    @Test
    fun test2() {
        val graph = UWGraph(5)
        graph.addEdge(0, 1, 4.0)
        graph.addEdge(1, 2, 1.0)
        graph.addEdge(2, 3, 7.0)
        graph.addEdge(3, 4, 6.0)
        graph.addEdge(0, 4, 2.0)
        graph.addEdge(1, 4, 3.0)
        graph.addEdge(1, 3, 5.0)
        val mst = strategy(graph)
        Assert.assertEquals(11.0, mst.weight(), 1e-12)
    }

    @Test
    fun test3() {
        val graph = readFromURL(URL("http://algs4.cs.princeton.edu/43mst/tinyEWG.txt"))
        val mst = strategy(graph)
        Assert.assertEquals(1.81, mst.weight(), 1e-12)
    }

    @Test
    fun test4() {
        val graph = readFromURL(URL("http://algs4.cs.princeton.edu/43mst/mediumEWG.txt"))
        val mst = strategy(graph)
        Assert.assertEquals(10.46351, mst.weight(), 1e-12)
    }

    @Test
    fun test5() {
        val graph = readFromURL(URL("http://algs4.cs.princeton.edu/43mst/1000EWG.txt"))
        val mst = strategy(graph)
        Assert.assertEquals(20.77320, mst.weight(), 1e-12)
    }

    @Test
    fun test6() {
        val graph = readFromURL(URL("http://algs4.cs.princeton.edu/43mst/10000EWG.txt"))
        val mst = strategy(graph)
        Assert.assertEquals(65.24072, mst.weight(), 1e-12)
    }

    fun readFromURL(url: URL): UWGraph {
        Scanner(url.openStream()).use { scanner ->
            val graph = UWGraph(scanner.nextInt())
            for (i in 0 until scanner.nextInt()) {
                graph.addEdge(scanner.nextInt(), scanner.nextInt(), scanner.nextDouble())
            }
            scanner.close()
            return graph
        }
    }
}
