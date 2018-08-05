package main.combinator

object FindMethod {
    def main(args: Array[String]): Unit = {
        val o = List(1, 2, 3, 4)

        val n = o.find(i => (i >= 2))
        println(n)
        println(n.getOrElse("Not Found"))

        val nn = o.find(i => (i == 9)).getOrElse("Not Found")
        println(nn)
    }
}
