package main.combinator

object FlattenMethod {
    def main(args: Array[String]): Unit = {
        val o = List(1, 2, 3)
        val p = List(4, 5, 6)

        println(o)
        println(p)

        val n = List(o, p)
        println(n)

        val m = n.flatten
        println(m)
    }
}
