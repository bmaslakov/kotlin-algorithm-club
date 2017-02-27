package im.uuddlrlrba.ktalgs.datastructures

import java.util.*

class Dequeue<T> {
    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    public var size: Int = 0
        private set

    private class Node<T>(var value: T) {
        var next: Node<T>? = null
    }

    public fun add(item: T) {
        val new = Node(item)
        val tail = this.tail
        if (tail == null) {
            head = new
            this.tail = new
        } else {
            tail.next = new
            this.tail = new
        }
        size++
    }

    public fun push(item: T) {
        val new = Node(item)
        new.next = head
        head = new
        size++
    }

    public fun peekFirst(): T {
        if (size == 0) throw NoSuchElementException()
        return head!!.value
    }

    public fun peekLast(): T {
        if (size == 0) throw NoSuchElementException()
        return tail!!.value
    }

    public fun pollFirst(): T {
        if (size == 0) throw NoSuchElementException()
        val old = head!!
        head = old.next
        return old.value
    }

    public fun pollLast(): T {
        if (size == 0) throw NoSuchElementException()
        var node = head!!
        while (node.next != null && node.next != tail) {
            node = node.next!!
        }
        val ret = node.next!!
        node.next = null
        tail = node
        return ret.value
    }
}
