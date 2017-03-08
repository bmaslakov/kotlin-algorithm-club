package io.uuddlrlrba.ktalgs.search

abstract class AbstractSearchStrategy<T> {
    abstract fun perform(arr: Array<T>, element: T): Int
}
