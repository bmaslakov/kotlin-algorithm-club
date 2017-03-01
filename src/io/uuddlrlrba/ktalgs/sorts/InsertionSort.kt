package io.uuddlrlrba.ktalgs.sorts

class InsertionSort: AbstractSortStrategy() {
    override fun <T : Comparable<T>> perform(arr: Array<T>) {
        for (i in 1..arr.size - 1) {
            for (j in i downTo 1) {
                if (arr[j - 1] < arr[j]) break
                exch(arr, j, j - 1)
            }
        }
    }
}
