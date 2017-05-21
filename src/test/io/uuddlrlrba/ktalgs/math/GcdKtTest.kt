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

import org.junit.Test

import org.junit.Assert.*

class GcdKtTest {
    @Test
    fun gcd() {
        assertEquals(1, gcd(1, 1))
        assertEquals(8, gcd(24, 16))
        assertEquals(8, gcd(16, 24))
        assertEquals(16, gcd(16, 16))
        assertEquals(1, gcd(13, 29))
        assertEquals(8, gcd(40, 16))
        assertEquals(5, gcd(40, 15))
    }

    @Test
    fun lcm() {
        assertEquals(1, lcm(1, 1))
        assertEquals(48, lcm(24, 16))
        assertEquals(48, lcm(16, 24))
        assertEquals(16, lcm(16, 16))
        assertEquals(377, lcm(13, 29))
        assertEquals(80, lcm(40, 16))
        assertEquals(120, lcm(40, 15))
    }
}
