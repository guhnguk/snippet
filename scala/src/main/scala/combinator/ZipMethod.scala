package main.combinator

object ZipMethod {
    def main(args: Array[String]): Unit = {
        val o = List(1, 2, 3, 4)
        val oo = List(5, 6, 7, 8, 9)

        val n = o zip oo
        println(n)

        val nn = o ::: oo
        println(nn)
    }
}
