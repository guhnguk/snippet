package main.collections

object OptionType {
    def main(args: Array[String]): Unit = {
        val student = Map(
            1 -> "Ahn",
            2 -> "Song",
            3 -> "Lee"
        )

        val one = student.get(1)
        val four = student.get(4)

        println(one)
        println(four)
        println(one.get)
        println(four.getOrElse("Not exist!"))
    }
}
