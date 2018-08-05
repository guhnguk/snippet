package main.collections

object MapType2 {
    def main(args: Array[String]): Unit = {
        var studentClass1 = Map (
            1 -> "Ryan",
            2 -> "Melicia",
            3 -> "Julia",
            4 -> "Andrew",
            5 -> "Joshua",
            6 -> "Jason",
            7 -> "Joel",
            8 -> "Philip",
            9 -> "Rachael"
        )

        studentClass1 += (10 -> "Transfer Student")
        studentClass1 -= 9

        var studentClass2 = Map(
            11 -> "Clack",
            12 -> "Woojin",
            13 -> "Yong",
            14 -> "GD"
        )

        var student = studentClass1 ++ studentClass2
        student.foreach(i => println(i))

        println()

        println(student(5))
    }
}
