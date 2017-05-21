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

import java.util.NoSuchElementException

// TODO: resize
class IndexedPriorityQueue<T>(size: Int, val comparator: Comparator<T>? = null) : Collection<T> {
    /**
     * maximum number of elements on PQ
     */
    private val maxN: Int = size

    /**
     * number of elements on PQ
     */
    public override var size: Int = 0
        private set

    /**
     * binary heap using 1-based indexing
     */
    private val pq: IntArray = IntArray(size + 1)

    /**
     * inverse of pq - qp[pq[i]] = pq[qp[i]] = i
     */
    private val qp: IntArray = IntArray(size + 1, { -1 })

    /**
     * keys[i] = priority of i
     */
    private val keys: Array<T?> = Array<Comparable<T>?>(size + 1, { null }) as Array<T?>

    /**
     * Associates key with index {@code i}.
     *
     * @param  i an index
     * @param  key the key to associate with index {@code i}
     * @throws IndexOutOfBoundsException unless {@code 0 <= i < maxN}
     * @throws IllegalArgumentException if there already is an item associated with index {@code i}
     */
    public fun insert(i: Int, key: T) {
        if (i < 0 || i >= maxN) throw IndexOutOfBoundsException()
        if (contains(i)) throw IllegalArgumentException("index is already in the priority queue")
        size++
        qp[i] = size
        pq[size] = i
        keys[i] = key
        swim(size)
    }

    /**
     * Decrease the key associated with index `i` to the specified value.
     *
     * @param  i the index of the key to decrease
     * @param  key decrease the key associated with index `i` to this key
     * @throws IndexOutOfBoundsException unless `0 <= i < maxN`
     * @throws IllegalArgumentException if `key >=` key associated with index `i`
     * @throws NoSuchElementException no key is associated with index `i`
     */
    public fun decreaseKey(i: Int, key: T) {
        if (i < 0 || i >= maxN) throw IndexOutOfBoundsException()
        if (!contains(i)) throw NoSuchElementException("index is not in the priority queue")
        if (!greater(keys[i]!!, key))
            throw IllegalArgumentException("Calling decreaseKey()" +
                    "with given argument would not strictly decrease the key")
        keys[i] = key
        swim(qp[i])
    }

    /**
     * Increase the key associated with index `i` to the specified value.
     *
     * @param  i the index of the key to increase
     * @param  key increase the key associated with index `i` to this key
     * @throws IndexOutOfBoundsException unless `0 <= i < maxN`
     * @throws IllegalArgumentException if `key <=` key associated with index `i`
     * @throws NoSuchElementException no key is associated with index `i`
     */
    public fun increaseKey(i: Int, key: T) {
        if (i < 0 || i >= maxN) throw IndexOutOfBoundsException()
        if (!contains(i)) throw NoSuchElementException("index is not in the priority queue")
        if (!less(keys[i]!!, key))
            throw IllegalArgumentException("Calling increaseKey()" +
                    "with given argument would not strictly increase the key")
        keys[i] = key
        sink(qp[i])
    }

    /**
     * Returns a minimum key.
     *
     * @return a minimum key
     * @throws NoSuchElementException if this priority queue is empty
     */
    fun peek(): Pair<Int, T> {
        if (size == 0) throw NoSuchElementException("Priority queue underflow")
        return Pair(pq[1], keys[pq[1]]!!)
    }

    /**
     * Removes a minimum key and returns its associated index.
     *
     * @return an index associated with a minimum key
     * @throws NoSuchElementException if this priority queue is empty
     */
    fun poll(): Pair<Int, T> {
        if (size == 0) throw NoSuchElementException("Priority queue underflow")
        val min = pq[1]
        val element = keys[min]
        exch(1, size--)
        sink(1)
        assert(min == pq[size + 1])
        qp[min] = -1        // delete
        keys[min] = null    // to help with garbage collection
        pq[size + 1] = -1   // not needed
        return Pair(min, element!!)
    }

    private fun less(x: T, y: T): Boolean {
        if (comparator != null) {
            return comparator.compare(x, y) < 0
        } else {
            val left = x as Comparable<T>
            return left < y
        }
    }

    private fun greater(x: T, y: T): Boolean {
        if (comparator != null) {
            return comparator.compare(x, y) > 0
        } else {
            val left = x as Comparable<T>
            return left > y
        }
    }

    private fun greater(i: Int, j: Int): Boolean {
        return greater(keys[pq[i]]!!, keys[pq[j]]!!)
    }

    private fun exch(i: Int, j: Int) {
        val swap = pq[i]
        pq[i] = pq[j]
        pq[j] = swap
        qp[pq[i]] = i
        qp[pq[j]] = j
    }

    private fun swim(n: Int) {
        var k = n
        while (k > 1 && greater(k / 2, k)) {
            exch(k, k / 2)
            k = k / 2
        }
    }

    private fun sink(n: Int) {
        var k = n
        while (2 * k <= size) {
            var j = 2 * k
            if (j < size && greater(j, j + 1)) j++
            if (!greater(k, j)) break
            exch(k, j)
            k = j
        }
    }

    public fun contains(i: Int): Boolean {
        if (i < 0 || i >= maxN) throw IndexOutOfBoundsException()
        return qp[i] != -1
    }

    override fun isEmpty(): Boolean {
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
        return keys.copyOfRange(1, size + 1).map { it!! }.iterator()
    }
}