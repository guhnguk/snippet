package main.function

object Sum {

    def mulply(a: Int, b: Int): Int = a * b

    def main(args: Array[String]): Unit = {
        var result = sum(1, 2)
        println(result)

        result = mulply(2, 3)
        println(result)
    }

    def sum(a: Int, b: Int) = {
        a + b
    }
}
