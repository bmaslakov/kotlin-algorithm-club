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

import io.uuddlrlrba.ktalgs.sorts.exch
import java.util.*
import kotlin.Comparator

class PriorityQueue<T>(capacity: Int, val comparator: Comparator<T>? = null) : Collection<T> {
    public override var size: Int = 0
        private set
    private var arr: Array<T?> = Array<Comparable<T>?>(capacity, { null }) as Array<T?>

    init {
        if (capacity <= 0) throw Error("Invalid capacity: $capacity")
    }

    public fun add(element: T) {
        if (size + 1 == arr.size) {
            resize()
        }
        arr[++size] = element
        swim(size)
    }

    public fun peek(): T {
        if (size == 0) throw NoSuchElementException()
        return arr[1]!!
    }

    public fun poll(): T {
        if (size == 0) throw NoSuchElementException()
        val res = peek()
        arr.exch(1, size--)
        sink(1)
        arr[size + 1] = null
        if ((size > 0) && (size == (arr.size - 1) / 4)) {
            resize()
        }
        return res
    }

    private fun swim(n: Int) {
        Companion.swim(arr, n, comparator)
    }

    private fun sink(n: Int) {
        Companion.sink(arr, n, size, comparator)
    }

    private fun resize() {
        val old = arr
        arr = Array<Comparable<T>?>(size * 2, { null }) as Array<T?>
        System.arraycopy(old, 0, arr, 0, size + 1)
    }

    public override fun isEmpty(): Boolean {
        return size == 0
    }
    
    override fun contains(element: T): Boolean {
        for (obj in this) {
            if (obj == element) return true
        }
        return false
    }

    override fun containsAll(elements: Collection<T>): Boolean {
        for (element in elements) {
            if (!contains(element)) return false
        }
        return true
    }

    override fun iterator(): Iterator<T> {
        return arr.copyOfRange(1, size + 1).map { it!! }.iterator()
    }

    companion object {
        private fun<T> greater(arr: Array<T?>, i: Int, j: Int, comparator: Comparator<T>? = null): Boolean {
            if (comparator != null) {
                return comparator.compare(arr[i], arr[j]) > 0
            } else {
                val left = arr[i]!! as Comparable<T>
                return left > arr[j]!!
            }
        }

        public fun<T> sink(arr: Array<T?>, a: Int, size: Int, comparator: Comparator<T>? = null) {
            var k = a
            while (2 * k <= size) {
                var j = 2 * k
                if (j < size && greater(arr, j, j + 1, comparator)) j++
                if (!greater(arr, k, j, comparator)) break
                arr.exch(k, j)
                k = j
            }
        }

        public fun<T> swim(arr: Array<T?>, size: Int, comparator: Comparator<T>? = null) {
            var n = size
            while (n > 1 && greater(arr, n / 2, n, comparator)) {
                arr.exch(n, n / 2)
                n /= 2
            }
        }
    }
}
