package main.collections

object MapType {
    def main(args: Array[String]): Unit = {
        val map1 = Map(
            "number1" -> "aa",
            "number2" -> "bb",
            "number3" -> 3,
            5 -> "cc"
        )

        println(map1.isEmpty)
        println("whole map: " + map1)
        println("keys: " + map1.keys)
        println("values: " + map1.values)

        println(map1("number1"))

        //map += ("number5" -> "TESTSTE")
        val map2 = map1 + ("number5" -> "TEST TEST")

    }
}
