package main.collections

object IteratorTest {
    def main(args: Array[String]): Unit = {
        val list = List("one", "two", "three")
        val i = list.iterator
        while (i.hasNext) {
            println(i.next)
        }
    }
}
