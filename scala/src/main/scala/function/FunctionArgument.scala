package main.function

object FunctionArgument {
    def main(args: Array[String]): Unit = {
        val g = f _
        println(f(1))
    }

    def f(i: Int) = i
}
