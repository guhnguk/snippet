package main.function

object DefaultParameter {

    def defaultParamFunction(a: Int = 4, b: Int=5): Int = a + b

    def main(args: Array[String]): Unit = {
        println("Default param: " + defaultParamFunction())
    }
}
