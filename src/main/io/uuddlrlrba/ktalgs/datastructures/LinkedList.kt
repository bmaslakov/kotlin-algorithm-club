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

enum class  LinkedType {
    END, NODE
}

class LinkedListKotlin<T>: Cloneable{

    private data class Node<T>(val item: T? = null,  val tail: LinkedListKotlin<T>? = null)

    private var type: LinkedType = LinkedType.END
    private var node: Node<T>? = null

    fun push(item: T) {
        val tail = this.clone() as? LinkedListKotlin<T>
        this.node = Node(item, tail)
        type = LinkedType.NODE
    }

    fun pop(): T? {
        val returnItem =  this.node?.copy()?.item
        val nextNode = this.node?.tail?.node
        this.node = Node(nextNode?.item, nextNode?.tail)
        return returnItem
    }
}

