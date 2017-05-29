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
 * Bubble sort is a simple sorting algorithm that repeatedly steps through the list to be sorted, compares
 * each pair of adjacent items and swaps them if they are in the wrong order. The pass through the list is repeated
 * until no swaps are needed, which indicates that the list is sorted. The algorithm, which is a comparison sort,
 * is named for the way smaller or larger elements "bubble" to the top of the list. Although the algorithm is simple,
 * it is too slow and impractical for most problems even when compared to insertion sort. It can be practical
 * if the input is usually in sorted order but may occasionally have some out-of-order elements nearly in position.
 */
@ComparisonSort
@StableSort
class BubbleSort : AbstractSortStrategy() {
    public override fun<T : Comparable<T>> perform(arr: Array<T>) {
        var exchanged: Boolean
        do {
            exchanged = false
            for (i in 1..arr.size - 1) {
                if (arr[i] < arr[i - 1]) {
                    arr.exch(i, i - 1)
                    exchanged = true
                }
            }
        } while (exchanged)
    }
}
