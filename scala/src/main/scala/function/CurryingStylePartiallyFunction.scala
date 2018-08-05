package main.function


object CurryingStylePartiallyFunction {
    def main(args: Array[String]): Unit = {
        val thisYear = 2018

        val fixedValueFunction = go(thisYear)_

        fixedValueFunction("test1")
        fixedValueFunction("test2")
        fixedValueFunction("test3")

    }

    def go(thisYear: Int)(string: String) = {
        println(string + ":" + thisYear)
    }
}
