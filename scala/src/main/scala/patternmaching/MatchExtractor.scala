package main.patternmaching

object MatchExtractor {
    def main(args: Array[String]): Unit = {
        val number1 = "010-222-2222"
        val number2 = "119"
        val number3 = "Pig eat a banana"
        val numberList = List(number1, number2, number3)

        for (number <- numberList) {
            number match {
                case Emergency() => println("Emergency calling ...")
                case Normal(number) => println("Normal calling ..." + number)
                case _ => println("Not matching ...")
            }
        }
    }
}

object Emergency {
    def unapply(number: String): Boolean = {
        if (number.length == 3 && number.forall(_.isDigit)) true
        else false
    }
}

object Normal {
    def unapply(number: String): Option[Int] = {
        try {
            var o = number.replaceAll("-", "")
            Some(number.replaceAll("-", "").toInt)
        } catch {
            case _: Throwable => None
        }
    }
}
