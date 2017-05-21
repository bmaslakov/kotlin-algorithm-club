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

package io.uuddlrlrba.ktalgs.datastructures.tree

class BinarySearchTree<K: Comparable<K>, V> {
    data class Node<K, V>(val key: K, var value: V, var left: Node<K, V>? = null, var right: Node<K, V>? = null, var size: Int = 1)

    private var root: Node<K, V>? = null

    fun add(key: K, value: V) {
        root = add(key, value, root)
    }

    private fun add(key: K, value: V, x: Node<K, V>?): Node<K, V> {
        if (x == null) return Node(key, value)
        if (key < x.key) {
            x.left = add(key, value, x.left)
        } else if (key > x.key) {
            x.right = add(key, value, x.right)
        } else {
            x.value = value
        }
        x.size = size(x.left) + size(x.right) + 1
        return x
    }

    fun size(): Int {
        return size(root)
    }

    private fun size(x: Node<K, V>?): Int {
        if (x == null) return 0 else return x.size
    }

    fun height(): Int {
        return height(root)
    }

    private fun height(x: Node<K, V>?): Int {
        if (x == null) return 0
        return maxOf(height(x.left), height(x.right)) + 1
    }

    fun isEmpty(): Boolean {
        return size() == 0
    }
}
