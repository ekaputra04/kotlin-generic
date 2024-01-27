package data

class MyData<T, U>(val firstData: T, val secondData: U) {
    fun getFirst(): T {
        return firstData
    }

    fun getSecond(): U {
        return secondData
    }

    fun printData() {
        println("Data is $firstData $secondData")
    }

}