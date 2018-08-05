package main.function

object MultiParameter {

    def printStrings(params: String*) = {
        for (param <- params) {
            println(param)
        }
    }

    def main(args: Array[String]): Unit = {
        printStrings("TEST#1", "TEST#2", "TEST#3")
    }
}
