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

package io.uuddlrlrba.ktalgs.geometry

class QuadNode<V> private constructor(
        private val NW: QuadTree<V>,
        private val NE: QuadTree<V>,
        private val SW: QuadTree<V>,
        private val SE: QuadTree<V>) : QuadTree<V> {
    override val frame: Rect = Rect(NW.frame.TL, SE.frame.BR)

    constructor(frame: Rect) : this(
            QuadNil<V>(Rect(frame.origin, frame.width / 2, frame.height / 2)),
            QuadNil<V>(Rect(Point(frame.x1 + frame.width / 2 + 1, frame.y1), frame.width / 2, frame.height / 2)),
            QuadNil<V>(Rect(Point(frame.x1, frame.y1 + frame.height / 2 + 1), frame.width / 2, frame.height / 2)),
            QuadNil<V>(Rect(frame.center, frame.width / 2, frame.height / 2))
    )

    override fun get(rect: Rect): Iterable<V> =
            (if (NW.frame.intersects(rect)) NW[rect] else emptyList()) +
                    (if (NE.frame.intersects(rect)) NE[rect] else emptyList()) +
                    (if (SW.frame.intersects(rect)) SW[rect] else emptyList()) +
                    (if (SE.frame.intersects(rect)) SE[rect] else emptyList())


    override fun plus(pair: Pair<Point, V>): QuadTree<V> = QuadNode(
            if (NW.frame.isInside(pair.first)) NW + pair else NW,
            if (NE.frame.isInside(pair.first)) NE + pair else NE,
            if (SW.frame.isInside(pair.first)) SW + pair else SW,
            if (SE.frame.isInside(pair.first)) SE + pair else SE
    )
}

class QuadLeaf<V>(override val frame: Rect, val value: Pair<Point, V>) : QuadTree<V> {
    override fun get(rect: Rect): Iterable<V> =
            if (rect.isInside(value.first)) listOf(value.second)
            else emptyList()
    override fun plus(pair: Pair<Point, V>): QuadTree<V> = QuadNode<V>(frame.cover(pair.first)) + value + pair
}

class QuadNil<V>(override val frame: Rect) : QuadTree<V> {
    override fun get(rect: Rect): Iterable<V> = emptyList()
    override fun plus(pair: Pair<Point, V>): QuadLeaf<V> = QuadLeaf(frame.cover(pair.first), value = pair)
}

interface QuadTree<V> {
    val frame: Rect
    operator fun get(rect: Rect): Iterable<V>
    operator fun plus(pair: Pair<Point, V>): QuadTree<V>
}

fun<V> emptyQuadTree(frame: Rect): QuadTree<V> = QuadNil(frame)
fun<V> quadTreeOf(frame: Rect, vararg pairs: Pair<Point, V>): QuadTree<V> {
    var empty = emptyQuadTree<V>(frame)
    for (pair in pairs) {
        empty += pair
    }
    return empty
}
