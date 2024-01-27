package app

class Invariant<T>(val data: T)

fun main() {
    val invariantString = Invariant("String")
//    val invariantAny: Invariant<Any> = invariantString // error
}