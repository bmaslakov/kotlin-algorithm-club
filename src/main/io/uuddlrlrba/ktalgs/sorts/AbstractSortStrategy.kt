package io.uuddlrlrba.ktalgs.sorts

abstract class AbstractSortStrategy {
    abstract fun<T : Comparable<T>> perform(arr: Array<T>)
}
