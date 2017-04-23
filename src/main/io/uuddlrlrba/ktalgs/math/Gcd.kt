package io.uuddlrlrba.ktalgs.math

fun gcd(a: Int, b: Int): Int {
    if (b == 0) return a
    return gcd(b, a % b)
}

fun lcm(a: Int, b: Int): Int {
    return a * b / gcd(a, b)
}
