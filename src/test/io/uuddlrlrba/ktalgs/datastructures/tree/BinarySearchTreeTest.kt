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

import kotlin.test.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class BinarySearchTreeTest {
    @Test
    fun empty() {
        val tree = BinarySearchTree<Int, Int>()
        assertEquals(0, tree.size)
        assertTrue(tree.isEmpty())
    }

    @Test
    fun sizeOfOne() {
        val tree = BinarySearchTree<Int, String>()
        tree.add(1, "1")
        assertFalse(tree.isEmpty())
        assertEquals(1, tree.size)
        assertEquals(1, tree.height())
        assertEquals(1, tree.min())
        assertEquals(1, tree.max())
        assertEquals("1", tree[1])
        tree.pollMin()
        assertTrue(tree.isEmpty())
    }

    @Test
    fun sizeOfThree() {
        val tree = BinarySearchTree<Int, String>()
        tree.add(1, "1")
        tree.add(2, "2")
        tree.add(3, "3")
        assertFalse(tree.isEmpty())
        assertEquals(3, tree.size)
        assertEquals(3, tree.height())
        assertEquals(1, tree.min())
        assertEquals(3, tree.max())
        assertEquals("1", tree[1])
        assertEquals("2", tree[2])
        assertEquals("3", tree[3])
        tree.pollMin()
        assertEquals(2, tree.min())
        assertEquals(3, tree.max())
        assertEquals("2", tree[2])
        assertEquals("3", tree[3])
        tree.pollMax()
        assertEquals(2, tree.min())
        assertEquals(2, tree.max())
        assertEquals("2", tree[2])
    }

    @Test
    fun overwrite() {
        val tree = BinarySearchTree<Int, String>()
        tree.add(1, "1")
        assertFalse(tree.isEmpty())
        assertEquals(1, tree.size)
        assertEquals(1, tree.height())
        assertEquals("1", tree[1])
        tree.add(1, "2")
        assertFalse(tree.isEmpty())
        assertEquals(1, tree.size)
        assertEquals(1, tree.height())
        assertEquals(1, tree.min())
        assertEquals(1, tree.max())
        assertEquals("2", tree[1])
        tree.pollMin()
        assertTrue(tree.isEmpty())
    }

    @Test
    fun letters() {
        val tree = BinarySearchTree<Char, String>()
        val letters = arrayOf(
            'j', 'p', 'q', 's', 'f', 'o', 'g', 'v', 'h', 'm', 'x', 'z',
            'l', 'n', 'd', 'c', 'a', 'r', 'b', 't', 'i', 'u', 'w', 'k', 'y', 'e'
        )
        letters.forEach { tree.add(it, it.toString()) }

        assertEquals(letters.toSet(), tree.keys)
        assertContentEquals(
            letters.map { it.toString() }.sorted().toTypedArray(),
            tree.values.sorted().toTypedArray()
        )

        assertEquals(26, tree.size)
        assertEquals('a', tree.min())
        assertEquals('z', tree.max())
        tree.pollMin()
        assertEquals(25, tree.size)
        assertEquals('b', tree.min())
        assertEquals('z', tree.max())
        tree.pollMax()
        assertEquals(24, tree.size)
        assertEquals('b', tree.min())
        assertEquals('y', tree.max())
        tree.pollMin()
        assertEquals(23, tree.size)
        assertEquals('c', tree.min())
        assertEquals('y', tree.max())
        tree.pollMax()
        assertEquals(22, tree.size)
        assertEquals('c', tree.min())
        assertEquals('x', tree.max())
        tree.pollMin()
        assertEquals(21, tree.size)
        assertEquals('d', tree.min())
        assertEquals('x', tree.max())
        tree.pollMax()
        assertEquals(20, tree.size)
        assertEquals('d', tree.min())
        assertEquals('w', tree.max())
        tree.pollMin()
        tree.pollMin()
        tree.pollMin()
        assertEquals(17, tree.size)
        assertEquals('g', tree.min())
        assertEquals('w', tree.max())
        tree.pollMax()
        tree.pollMax()
        tree.pollMax()
        assertEquals(14, tree.size)
        assertEquals('g', tree.min())
        assertEquals('t', tree.max())
        tree.pollMin()
        tree.pollMin()
        tree.pollMin()
        tree.pollMin()
        tree.pollMin()
        assertEquals(9, tree.size)
        assertEquals('l', tree.min())
        assertEquals('t', tree.max())
        tree.pollMax()
        tree.pollMax()
        tree.pollMax()
        tree.pollMax()
        tree.pollMax()
        assertEquals(4, tree.size)
        assertEquals('l', tree.min())
        assertEquals('o', tree.max())
        tree.pollMin()
        assertEquals(3, tree.size)
        assertEquals('m', tree.min())
        assertEquals('o', tree.max())
        tree.pollMax()
        assertEquals(2, tree.size)
        assertEquals('m', tree.min())
        assertEquals('n', tree.max())
        tree.pollMin()
        assertEquals(1, tree.size)
        assertEquals('n', tree.min())
        assertEquals('n', tree.max())
        tree.pollMin()
        assertTrue(tree.isEmpty())
    }

    @Test
    fun remove() {
        val tree = BinarySearchTree<Int, String>()
        for (i in 0..30) {
            tree.add(i, (i * i).toString())
        }

        for (i in 0..30) {
            assertEquals((i * i).toString(), tree[i])
        }

        var counter = 0
        for ((key, value) in tree) {
            assertEquals(counter, key)
            assertEquals((counter * counter).toString(), value)
            counter++
        }

        tree.remove(15)
        tree.remove(0)
        tree.remove(30)
        assertEquals(1, tree.min())
        assertEquals(29, tree.max())
        tree.remove(14)
        tree.remove(16)
        tree.remove(1)
        tree.remove(29)
        assertEquals(2, tree.min())
        assertEquals(28, tree.max())
        tree.remove(13)
        tree.remove(17)
        tree.remove(2)
        tree.remove(28)
        assertEquals(3, tree.min())
        assertEquals(27, tree.max())
        tree.remove(12)
        tree.remove(18)
        tree.remove(3)
        tree.remove(27)
        assertEquals(4, tree.min())
        assertEquals(26, tree.max())
        tree.remove(11)
        tree.remove(19)
        tree.remove(4)
        tree.remove(26)
        assertEquals(5, tree.min())
        assertEquals(25, tree.max())
        assertEquals(12, tree.size)

        assertEquals("25", tree[5])
        assertEquals("36", tree[6])
        assertEquals("49", tree[7])
        assertEquals("64", tree[8])
        assertEquals("81", tree[9])
        assertEquals("100", tree[10])
        assertEquals("400", tree[20])
        assertEquals("441", tree[21])
        assertEquals("484", tree[22])
        assertEquals("529", tree[23])
        assertEquals("576", tree[24])
        assertEquals("625", tree[25])
    }

    @Test
    fun emptyMinFails() {
        assertFailsWith<NoSuchElementException> { BinarySearchTree<Int, Unit>().min() }
    }

    @Test
    fun emptyMaxFails() {
        assertFailsWith<NoSuchElementException> { BinarySearchTree<Int, Unit>().max() }
    }

    @Test
    fun emptyPollMinFails() {
        assertFailsWith<NoSuchElementException> { BinarySearchTree<Int, Unit>().pollMin() }
    }

    @Test
    fun emptyPollMaxFails() {
        assertFailsWith<NoSuchElementException> { BinarySearchTree<Int, Unit>().pollMax() }
    }
}
