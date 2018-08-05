package main.combinator

object FilterMethod {
    def main(args: Array[String]): Unit = {
        val o = List(1, 2, 3, 4, 5)

        val n = o.filter(i => (i > 3))
        println(n)

        val m = o.filter(i => (i > 3)).map(i => (i*10))
        println(m)
    }
}
