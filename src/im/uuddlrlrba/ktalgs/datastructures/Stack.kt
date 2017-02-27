package im.uuddlrlrba.ktalgs.datastructures

import java.util.*

class Stack<T> {
    private var head: Node<T>? = null
    public var size: Int = 0
        private set

    private class Node<T>(var value: T) {
        var next: Node<T>? = null
    }

    public fun push(item: T) {
        val new = Node(item)
        new.next = head
        head = new
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
