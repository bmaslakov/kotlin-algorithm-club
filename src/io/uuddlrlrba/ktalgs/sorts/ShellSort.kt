package io.uuddlrlrba.ktalgs.sorts

class ShellSort : AbstractSortStrategy() {
    public override fun<T : Comparable<T>> perform(arr: Array<T>) {
        var h = 1
        while (h < arr.size / 3) {
            h = h * 3 + 1
        }

        while (h >= 1) {
            for (i in h..arr.size - 1) {
                for (j in i downTo h step h) {
                    if (arr[j - h] < arr[j]) break
                    exch(arr, j, j - h)
                }
            }
            h /= 3
        }
    }
}
