package io.uuddlrlrba.ktalgs.sorts

public fun<T> exch(arr: Array<T>, i: Int, j: Int) {
    val tmp = arr[i]
    arr[i] = arr[j]
    arr[j] = tmp
}