package io.uuddlrlrba.ktalgs.datastructures

import io.uuddlrlrba.ktalgs.sorts.exch
import java.util.*

class PriorityQueue<T : Comparable<T>>(size: Int) : Collection<T> {
    public override var size: Int = 0
        private set
    private var arr: Array<T?> = Array<Comparable<T>?>(size, { null }) as Array<T?>

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
        exch(arr, 1, size--)
        sink(1)
        arr[size + 1] = null
        if ((size > 0) && (size == (arr.size - 1) / 4)) {
            resize()
        }
        return res
    }

    private fun sink(a: Int) {
        var k = a
        while (2 * k <= size) {
            var j = 2 * k
            if (j < size && arr[j]!! > arr[j + 1]!!) j++
            if (arr[k]!! <= arr[j]!!) break
            exch(arr, k, j)
            k = j
        }
    }

    private fun swim(size: Int) {
        var n = size
        while (n > 1 && arr[n / 2]!! > arr[n]!!) {
            exch(arr, n, n / 2)
            n /= 2
        }
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
}
