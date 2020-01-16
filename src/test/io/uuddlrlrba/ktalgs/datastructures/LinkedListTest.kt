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

package io.uuddlrlrba.ktalgs.datastructures

import com.carrotsearch.junitbenchmarks.BenchmarkOptions
import com.carrotsearch.junitbenchmarks.BenchmarkRule
import org.junit.Before
import org.junit.Rule
import org.junit.Test


class LinkedListTest {

    private lateinit var linkedList: LinkedListKotlin<Int>

    @Before
    fun init() {
        linkedList = LinkedListKotlin()
    }

    @get:Rule
    public val benchmarkRule: BenchmarkRule = BenchmarkRule()

    @Test
    fun emptyTest() {
        val test2 = linkedList.pop()
    }


    @Test
    fun pushAndPopTest() {
        val linkedList: LinkedListKotlin<Int> = LinkedListKotlin()
        linkedList.push(1)
        linkedList.push(2)
        linkedList.push(3)
        val test1 = linkedList.pop()
        val test2 = linkedList.pop()
    }

    @Test
    @BenchmarkOptions(concurrency = 1, warmupRounds = 0, benchmarkRounds = 1)
    fun benchmarkSomeWork()  {
        for (i in 0..1000000) {
            linkedList.push(i)
        }
        for (i in 0..1000000) {
            linkedList.pop()
        }
    }
}
