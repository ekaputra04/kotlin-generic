package app

import data.MyData

fun main() {
    val myData: MyData<String, Int> = MyData<String, Int>("Eka", 20)
    myData.printData()
}