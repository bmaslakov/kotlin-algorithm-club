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

data class Rect(val x1: Int, val y1: Int, val x2: Int, val y2: Int) {
    val width = x2 - x1
    val height = y2 - y1
    val origin = Point(x1, y1)
    val center = Point(origin.x + width / 2, origin.y + height / 2)
    val TL = origin
    val BR = Point(origin.x + width, origin.y + height)

    constructor(TL: Point, BR: Point) : this(TL, (BR.x - TL.x), (BR.y - TL.y))

    constructor(origin: Point, width: Int, height: Int) : this(origin.x, origin.y, origin.x + width, origin.y + height)

    fun isInside(point: Point): Boolean =
            point.x >= origin.x && point.y >= origin.y &&
                    point.x <= origin.x + width && point.y <= origin.y + height

    fun cover(point: Point): Rect =
            Rect(Point(minOf(x1, point.x), minOf(y1, point.y)), Point(maxOf(x2, point.x), maxOf(y2, point.y)))

    fun intersects(other: Rect) =
            !(other.x1 > this.x2 || other.x2 < this.x1 || other.y1 > this.y2 || other.y2 < this.y1)
}
