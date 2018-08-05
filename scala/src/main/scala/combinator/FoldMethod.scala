package main.combinator

object FoldMethod {
    def main(args: Array[String]): Unit = {
        val o = List(1, 3, 5, 7)

        val n = o.foldLeft(0)((i, j) => (i+j))
        println(n)

        val m = o.foldRight(0)((i, j) => (i+j))
        println(m)
    }
}
