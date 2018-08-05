package main.collections

object ArrayType {
    def main(args: Array[String]): Unit = {
        val arrayA = Array(1, 2, 3, 4, 5)
        for (x <- arrayA) {
            println(x)
        }

        val arrayB = Array("a", "b", "c", "d")
        for (x <- arrayB) {
            println(x)
        }

        val arrayC = Array(13, "hi", 1.42)
        for (x <- arrayC) {
            println(x)
        }
    }
}
