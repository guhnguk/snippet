package main.klass

object CaseKlass {
    def main(args: Array[String]): Unit = {
        val apple = Fruit2("Apple")
        println(apple.name)
    }

    case class Fruit2(name: String)
}
