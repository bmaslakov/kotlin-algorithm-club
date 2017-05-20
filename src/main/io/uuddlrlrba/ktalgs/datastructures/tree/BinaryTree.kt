package io.uuddlrlrba.ktalgs.datastructures.tree

import io.uuddlrlrba.ktalgs.datastructures.Queue

class BinaryTree(var value: Int, var left: BinaryTree?, var right: BinaryTree?) {
    constructor(value: Int): this(value, null, null)

    fun size(): Int {
        return size(this)
    }

    fun add(value: Int) {
        // adds the on the first empty level
        val queue = Queue<BinaryTree>()
        queue.add(this)
        while (!queue.isEmpty()) {
            val x = queue.poll()
            if (x.left == null) {
                x.left = BinaryTree(value)
                return
            } else if (x.right == null) {
                x.right = BinaryTree(value)
                return
            } else {
                queue.add(x.left!!)
                queue.add(x.right!!)
            }
        }
    }

    companion object {
        private fun size(tree: BinaryTree?): Int {
            return if (tree == null) 0 else size(tree.left) + size(tree.right) + 1
        }
    }
}
