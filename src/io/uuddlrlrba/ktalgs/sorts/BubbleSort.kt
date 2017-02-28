package io.uuddlrlrba.ktalgs.sorts

class BubbleSort {
    public fun<T : Comparable<T>> perform(arr: Array<T>) {
        var exchanged: Boolean
        do {
            exchanged = false
            for (i in 1..arr.size - 1) {
                if (arr[i] < arr[i - 1]) {
                    exch(arr, i, i - 1)
                    exchanged = true
                }
            }
        } while (exchanged)
    }
}
