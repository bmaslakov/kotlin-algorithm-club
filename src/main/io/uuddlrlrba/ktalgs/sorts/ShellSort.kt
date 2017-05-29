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
 * Shellsort, also known as Shell sort or Shell's method, is an in-place comparison sort. It can be seen as either a
 * generalization of sorting by exchange (bubble sort) or sorting by insertion (insertion sort). The method starts by
 * sorting pairs of elements far apart from each other, then progressively reducing the gap between elements to be
 * compared. Starting with far apart elements, it can move some out-of-place elements into position faster than
 * a simple nearest neighbor exchange. Donald Shell published the first version of this sort in 1959.
 * This implementation uses the gap sequence proposed by Pratt in 1971: 1, 4, 13, 40...
 */
@ComparisonSort
@StableSort
class ShellSort : AbstractSortStrategy() {
    public override fun<T : Comparable<T>> perform(arr: Array<T>) {
        var h = 1
        while (h < arr.size / 3) {
            h = h * 3 + 1
        }

        while (h >= 1) {
            for (i in h..arr.size - 1) {
                for (j in i downTo h step h) {
                    if (arr[j - h] < arr[j]) break
                    arr.exch(j, j - h)
                }
            }
            h /= 3
        }
    }
}
