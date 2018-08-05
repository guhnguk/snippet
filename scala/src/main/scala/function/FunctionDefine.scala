package main.function

object FunctionDefine {
    def main(args: Array[String]): Unit = {
        println("Returned Value: " + name())
    }

    def name() = {
        val a = 10
        a
    }
}
