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

/**
 * Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
 * Each iteration, insertion sort removes one element from the input data, finds the location it belongs within
 * the sorted list, and inserts it there. It repeats until no input elements remain.
 */
@ComparisonSort
@StableSort
class InsertionSort: AbstractSortStrategy() {
    override fun <T : Comparable<T>> perform(arr: Array<T>) {
        for (i in 1..arr.size - 1) {
            for (j in i downTo 1) {
                if (arr[j - 1] < arr[j]) break
                arr.exch(j, j - 1)
            }
        }
    }
}
