package main.collections

object SetType {
    def main(args: Array[String]): Unit = {
        var basket: Set[String] = Set()

        basket += "Berry"
        basket += "Grape"
        basket += "Grape"
        basket += "Apple"
        basket += "Grape"
        basket += "Banana"

        println(basket)
    }
}
