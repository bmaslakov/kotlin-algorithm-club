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

package io.uuddlrlrba.ktalgs.sorts

import io.uuddlrlrba.ktalgs.datastructures.PriorityQueue

/**
 * Heap sort is a comparison based sorting technique based on Binary Heap data structure. It is similar to selection
 * sort where we first find the maximum element and place the maximum element at the end. We repeat the same process
 * for remaining element.
 */
@ComparisonSort
@UnstableSort
class HeapSort : AbstractSortStrategy() {
    override fun <T : Comparable<T>> perform(arr: Array<T>) {
        for (k in arr.size / 2 downTo 1) {
            PriorityQueue.sink(arr as Array<T?>, k - 1, arr.size - 1, reverseOrder<T>())
        }
        for (k in arr.size downTo 1) {
            arr.exch(0, k - 1)
            PriorityQueue.sink(arr as Array<T?>, 0, k - 2, reverseOrder<T>())
        }
    }
}
