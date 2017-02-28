package io.uuddlrlrba.ktalgs.sorts

class SelectionSort {
    public fun<T : Comparable<T>> perform(arr: Array<T>) {
        for (i in arr.indices) {
            var min = i
            for (j in i+1..arr.size) {
                if (arr[j] < arr[min]) {
                    min = j
                }
            }
            if (min != i) exch(arr, min, i)
        }
    }
}
