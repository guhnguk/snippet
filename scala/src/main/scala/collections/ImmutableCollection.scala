package main.collections

object ImmutableCollection {
    def main(args: Array[String]): Unit = {
        val list = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

        def foreach(list: List[Int]) = {
            def add(list: List[Int], total: Int): Int = {
                list match {
                    case List() => total
                    case List(item) => total + item
                    case head::tail => add(tail, total + head)
                }
            }

            add(list, 0)
        }

        println(foreach(list))

        val result = list.foldLeft(0)((total, item) => total + item)
        println(result)
    }
}
