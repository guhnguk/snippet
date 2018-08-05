package main.collections

object ListType {
    def main(args: Array[String]): Unit = {
        val listA = List(1, 2, 3, 4, 5)
        for (x <- listA) {
            print(x + " ")
        }

        println()
        val listB = List("a", "b", "c", "d", "e")
        for (x <- listB) {
            print(x + " ")

        }

        println()
        val listC = List("a", 1, "c", 100.2, "e")
        for (x <- listC) {
            print(x + " ")
        }

        println()
        val listD = "a" :: "B" :: 10 :: "qwer" :: 100.5 :: Nil
        for (x <- listD) {
            print(x + " ")
        }

        // empty list creation
        val emptyList: List[Int] = Nil
        //        emptyList ++ "1"
        //        print(emptyList(0))

        println()
        for (x <- 1 until listD.length - 2) {
            print(x + " ")
        }

        println()
        for (x <- 1 until listD.size - 2) {
            print(x + " ")
        }

        // list flattern
        val list1 = "a" :: "b" :: "c" :: Nil
        val list2 = "d" :: "e" :: Nil
        val list0 = list1 ::: list2

        println()
        for (x <- list0) {
            print(x + " ")
        }

        println()
        for (x <- 0 until list0.size) {
            print(list0(x) + " ")
        }

        val list3 = "a" :: "b" :: "c" :: Nil
        val list4 = 1 :: 2 :: 3 :: Nil
        val list5 = 2 :: 2 :: 4 :: Nil
        println()
        println("list3 ++ list4 => " + list3 ++ list4)
        println("list3.apply(0) => " + list3.apply(0))
        println("list3.reverse => " + list3.reverse)
        println("list4.max => " + list4.max)
        println("list4.min => " + list4.min)
        println("list4.sum => " + list4.sum)
        println("list4.mkString(\",\") => " + list4.mkString(","))
        println("list4.exists(a => a > 3) => " + list4.exists(a => a > 3))
        println("list4.exists(_ > 3) => " + list4.exists(_ > 3))
        println("list4.contains(1) => " + list4.contains(1))
        println("list4.isEmpty => " + list4.isEmpty)
        println("list4.distinct => " + list4.distinct)
    }
}
