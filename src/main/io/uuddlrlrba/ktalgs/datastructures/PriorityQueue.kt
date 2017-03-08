package io.uuddlrlrba.ktalgs.datastructures

import io.uuddlrlrba.ktalgs.sorts.exch
import java.util.*

class PriorityQueue(size: Int) {
    public var size: Int = 0
        private set
    private var arr: IntArray = IntArray(size + 1)

    public fun add(element: Int) {
        if (size + 1 == arr.size) {
            resize()
        }
        arr[++size] = element
        swim(size)
    }

    public fun peek(): Int {
        if (size == 0) throw NoSuchElementException()
        return arr[1]
    }

    public fun poll(): Int {
        if (size == 0) throw NoSuchElementException()
        val res = peek()
        exch(arr, 1, size--)
        sink(1)
        arr[size + 1] = 0
        if ((size > 0) && (size == (arr.size - 1) / 4)) {
            resize()
        }
        return res
    }

    private fun sink(a: Int) {
        var k = a
        while (2 * k <= size) {
            var j = 2 * k
            if (j < size && arr[j] > arr[j + 1]) j++
            if (arr[k] <= arr[j]) break
            exch(arr, k, j)
            k = j
        }
    }

    private fun swim(size: Int) {
        var n = size
        while (n > 1 && arr[n / 2] > arr[n]) {
            exch(arr, n, n / 2)
            n /= 2
        }
    }

    private fun resize() {
        val old = arr
        arr = IntArray(size * 2)
        System.arraycopy(old, 0, arr, 0, size + 1)
    }

    public fun isEmpty(): Boolean {
        return size == 0
    }
}
