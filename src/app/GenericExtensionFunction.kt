package app

class Data<T>(val data: T)

fun Data<String>.print() {
    val data: String = this.data
    println(data)
}

fun Data<Int>.printInt() {
    val data: Int = this.data
    println(data)
}

fun main() {
    val data1 = Data("Eka")
    data1.print()

    val data2 = Data(10)
//    data2.print() // error, karena function print() hanya menerima generic type String
    data2.printInt()
}