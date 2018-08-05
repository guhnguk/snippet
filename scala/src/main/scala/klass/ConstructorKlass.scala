package main.klass

object ConstructorKlass {
    def main(args: Array[String]): Unit = {
        val apple = new Fruit("Apple")
        println(apple.name)
    }
}

class Fruit(input: String) {
    var name = input
}