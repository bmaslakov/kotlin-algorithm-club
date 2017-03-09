package io.uuddlrlrba.ktalgs.sorts

public fun<T> exch(arr: Array<T>, i: Int, j: Int) {
    val tmp = arr[i]
    arr[i] = arr[j]
    arr[j] = tmp
}

public fun exch(arr: IntArray, i: Int, j: Int) {
    val tmp = arr[i]
    arr[i] = arr[j]
    arr[j] = tmp
}

@Retention(AnnotationRetention.SOURCE)
annotation class ComparisonSort

@Retention(AnnotationRetention.SOURCE)
annotation class StableSort

@Retention(AnnotationRetention.SOURCE)
annotation class UnstableSort
