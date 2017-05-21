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
