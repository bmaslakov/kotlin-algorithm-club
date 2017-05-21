package io.uuddlrlrba.ktalgs.datastructures.tree

import org.junit.Assert
import org.junit.Test

class BinarySearchTreeTest {
    @Test
    fun empty() {
        val tree = BinarySearchTree<Int, Int>()
        Assert.assertEquals(0, tree.size())
        Assert.assertTrue(tree.isEmpty())
    }

    @Test
    fun sizeOfOne() {
        val tree = BinarySearchTree<Int, Int>()
        tree.add(1, 1)
        Assert.assertFalse(tree.isEmpty())
        Assert.assertEquals(1, tree.size())
        Assert.assertEquals(1, tree.height())
    }

    @Test
    fun sizeOfThree() {
        val tree = BinarySearchTree<Int, Int>()
        tree.add(1, 1)
        tree.add(2, 2)
        tree.add(3, 3)
        Assert.assertFalse(tree.isEmpty())
        Assert.assertEquals(3, tree.size())
        Assert.assertEquals(3, tree.height())
    }

    @Test
    fun overwrite() {
        val tree = BinarySearchTree<Int, Int>()
        tree.add(1, 1)
        Assert.assertFalse(tree.isEmpty())
        Assert.assertEquals(1, tree.size())
        Assert.assertEquals(1, tree.height())
        tree.add(1, 2)
        Assert.assertFalse(tree.isEmpty())
        Assert.assertEquals(1, tree.size())
        Assert.assertEquals(1, tree.height())
    }
}
