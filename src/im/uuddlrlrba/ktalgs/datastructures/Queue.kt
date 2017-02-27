package im.uuddlrlrba.ktalgs.datastructures

import java.util.*

class Queue<T> {
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

    public fun peek(): T {
        if (size == 0) throw NoSuchElementException()
        return head!!.value
    }

    public fun poll(): T {
        if (size == 0) throw NoSuchElementException()
        val old = head!!
        head = old.next
        return old.value
    }
}
