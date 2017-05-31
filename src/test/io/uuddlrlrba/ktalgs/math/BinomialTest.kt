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

package io.uuddlrlrba.ktalgs.math

import org.junit.Assert
import org.junit.Test

class BinomialTest {
    @Test
    fun test1() {
        Assert.assertEquals(0, binomial(0, 1))
        Assert.assertEquals(1, binomial(1, 1))
        Assert.assertEquals(2, binomial(2, 1))
        Assert.assertEquals(3, binomial(3, 1))
        Assert.assertEquals(3, binomial(3, 2))
        Assert.assertEquals(4, binomial(4, 1))

        Assert.assertEquals(1, binomial(5, 0))
        Assert.assertEquals(5, binomial(5, 1))
        Assert.assertEquals(10, binomial(5, 2))
        Assert.assertEquals(10, binomial(5, 3))
        Assert.assertEquals(5, binomial(5, 4))
        Assert.assertEquals(1, binomial(5, 5))

        Assert.assertEquals(1, binomial(6, 0))
        Assert.assertEquals(6, binomial(6, 1))
        Assert.assertEquals(15, binomial(6, 2))
        Assert.assertEquals(20, binomial(6, 3))
        Assert.assertEquals(15, binomial(6, 4))
        Assert.assertEquals(6, binomial(6, 5))
        Assert.assertEquals(1, binomial(6, 6))
    }
}
