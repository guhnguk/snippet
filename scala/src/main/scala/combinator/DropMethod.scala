package main.combinator

object DropMethod {
    def main(args: Array[String]): Unit = {
        val o = List(0, 1, 2, 3, 4, 5)

        val n = o.drop(4)
        println(n)

        val nn = o.dropWhile(i => (i<3))
        println(nn)
    }
}
