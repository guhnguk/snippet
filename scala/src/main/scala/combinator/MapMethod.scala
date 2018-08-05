package main.combinator

object MapMethod {
    def main(args: Array[String]): Unit = {
        val o = List(1, 2, 3, 4)
        println(o)

        val n = o.map(i => (i*10))
        println(n)

        println(o.foreach(i => i*10))

        o.foreach(i => println(i*10))
    }
}
