package io.uuddlrlrba.ktalgs.search

class BinarySearch<T: Comparable<T>>: AbstractSearchStrategy<T>() {
    override fun perform(arr: Array<T>, element: T): Int {
        var lo = 0
        var hi = arr.size - 1
        while (lo <= hi) {
            val mid = (lo + hi) / 2
            if (element < arr[mid]) {
                hi = mid - 1
            } else if (element > arr[mid]) {
                lo = mid + 1
            } else {
                return mid
            }
        }
        return -1
    }
}
