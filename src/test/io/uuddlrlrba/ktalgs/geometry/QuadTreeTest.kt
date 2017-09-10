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

import org.junit.Assert
import org.junit.Test

class QuadTreeTest {
    @Test
    fun naiveTest1() {
        val qt = quadTreeOf(Rect(0, 0, 100, 100),
                Point(5, 20) to "Foo",
                Point(50, 32) to "Bar",
                Point(47, 96) to "Baz",
                Point(50, 50) to "Bing",
                Point(12, 0) to "Bong"
        )

        val points1 = qt[Rect(4, 0, 51, 98)].sorted()
        Assert.assertEquals(listOf("Bar", "Baz", "Bing", "Bong", "Foo"), points1)

        val points2 = qt[Rect(5, 0, 50, 96)].sorted()
        Assert.assertEquals(listOf("Bar", "Baz", "Bing", "Bong", "Foo"), points2)

        val points3 = qt[Rect(55, 0, 50, 96)]
        Assert.assertEquals(0, points3.count())

        val points4 = qt[Rect(4, 19, 6, 21)].sorted()
        Assert.assertEquals(listOf("Foo"), points4)
    }
}
