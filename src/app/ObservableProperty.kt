package app

import kotlin.properties.Delegates
import kotlin.properties.ObservableProperty
import kotlin.reflect.KProperty

class LogObservableProperty<T>(param: T) : ObservableProperty<T>(param) {
    override fun beforeChange(property: KProperty<*>, oldValue: T, newValue: T): Boolean {
        println("Before change ${property.name} from $oldValue to $newValue")
        return true
    }

    override fun afterChange(property: KProperty<*>, oldValue: T, newValue: T) {
        println("After change ${property.name} from $oldValue to $newValue")
    }
}

class Car(brand: String, year: Int) {
    var brand: String by LogObservableProperty(brand)
    var year: Int by LogObservableProperty(year)

    //    tanpa membuat class, langsung menggunakan objek Delegates
    var owner: String by Delegates.notNull<String>()
    var description: String by Delegates.vetoable("") { property, oldValue, newValue ->
        println("Before change ${property.name} from $oldValue to $newValue")
        true
    }
    var other: String by Delegates.observable("") { property, oldValue, newValue ->
        println("After change ${property.name} from $oldValue to $newValue")
    }
}

fun main() {
    var car = Car("Toyota", 2023)

    println(car.brand)
    println(car.year)

    car.brand = "Wuling"
    car.year = 2024

    println(car.brand)
    println(car.year)

    car.owner = "Eka"
    println(car.owner)

    car.description = "Description"
    println(car.description)

    car.other = "Other"
    println(car.other)
}