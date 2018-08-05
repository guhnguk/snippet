package main.klass

object ObjectKlass {
    def main(args: Array[String]): Unit = {
        val car = new Vehicle()
        println(car.price)
        println(car.hood)
    }

    class Vehicle() {
        var price: Int = 10000
        var hood: String = "expensive hood"
    }
}
