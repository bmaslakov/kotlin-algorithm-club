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
        Assert.assertEquals(1, tree.min())
        Assert.assertEquals(1, tree.max())
        tree.pollMin()
        Assert.assertTrue(tree.isEmpty())
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
        Assert.assertEquals(1, tree.min())
        Assert.assertEquals(3, tree.max())
        tree.pollMin()
        Assert.assertEquals(2, tree.min())
        Assert.assertEquals(3, tree.max())
        tree.pollMax()
        Assert.assertEquals(2, tree.min())
        Assert.assertEquals(2, tree.max())
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
        Assert.assertEquals(1, tree.min())
        Assert.assertEquals(1, tree.max())
        tree.pollMin()
        Assert.assertTrue(tree.isEmpty())
    }

    @Test
    fun letters() {
        val tree = BinarySearchTree<Char, String>()
        val letters = arrayOf('j', 'p', 'q', 's', 'f', 'o', 'g', 'v', 'h', 'm', 'x', 'z',
                'l', 'n', 'd', 'c', 'a', 'r', 'b', 't', 'i', 'u', 'w', 'k', 'y', 'e')
        letters.forEach { tree.add(it, it.toString()) }
        Assert.assertEquals(26, tree.size())
        Assert.assertEquals('a', tree.min())
        Assert.assertEquals('z', tree.max())
        tree.pollMin()
        Assert.assertEquals(25, tree.size())
        Assert.assertEquals('b', tree.min())
        Assert.assertEquals('z', tree.max())
        tree.pollMax()
        Assert.assertEquals(24, tree.size())
        Assert.assertEquals('b', tree.min())
        Assert.assertEquals('y', tree.max())
        tree.pollMin()
        Assert.assertEquals(23, tree.size())
        Assert.assertEquals('c', tree.min())
        Assert.assertEquals('y', tree.max())
        tree.pollMax()
        Assert.assertEquals(22, tree.size())
        Assert.assertEquals('c', tree.min())
        Assert.assertEquals('x', tree.max())
        tree.pollMin()
        Assert.assertEquals(21, tree.size())
        Assert.assertEquals('d', tree.min())
        Assert.assertEquals('x', tree.max())
        tree.pollMax()
        Assert.assertEquals(20, tree.size())
        Assert.assertEquals('d', tree.min())
        Assert.assertEquals('w', tree.max())
        tree.pollMin()
        tree.pollMin()
        tree.pollMin()
        Assert.assertEquals(17, tree.size())
        Assert.assertEquals('g', tree.min())
        Assert.assertEquals('w', tree.max())
        tree.pollMax()
        tree.pollMax()
        tree.pollMax()
        Assert.assertEquals(14, tree.size())
        Assert.assertEquals('g', tree.min())
        Assert.assertEquals('t', tree.max())
        tree.pollMin()
        tree.pollMin()
        tree.pollMin()
        tree.pollMin()
        tree.pollMin()
        Assert.assertEquals(9, tree.size())
        Assert.assertEquals('l', tree.min())
        Assert.assertEquals('t', tree.max())
        tree.pollMax()
        tree.pollMax()
        tree.pollMax()
        tree.pollMax()
        tree.pollMax()
        Assert.assertEquals(4, tree.size())
        Assert.assertEquals('l', tree.min())
        Assert.assertEquals('o', tree.max())
        tree.pollMin()
        Assert.assertEquals(3, tree.size())
        Assert.assertEquals('m', tree.min())
        Assert.assertEquals('o', tree.max())
        tree.pollMax()
        Assert.assertEquals(2, tree.size())
        Assert.assertEquals('m', tree.min())
        Assert.assertEquals('n', tree.max())
        tree.pollMin()
        Assert.assertEquals(1, tree.size())
        Assert.assertEquals('n', tree.min())
        Assert.assertEquals('n', tree.max())
        tree.pollMin()
        Assert.assertTrue(tree.isEmpty())
    }

    @Test(expected= NoSuchElementException::class)
    fun emptyMinFails() {
        BinarySearchTree<Int, Unit>().min()
    }

    @Test(expected= NoSuchElementException::class)
    fun emptyMaxFails() {
        BinarySearchTree<Int, Unit>().max()
    }

    @Test(expected= NoSuchElementException::class)
    fun emptyPollMinFails() {
        BinarySearchTree<Int, Unit>().pollMin()
    }

    @Test(expected= NoSuchElementException::class)
    fun emptyPollMaxFails() {
        BinarySearchTree<Int, Unit>().pollMax()
    }
}
