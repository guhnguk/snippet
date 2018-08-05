package main.conditionsloops

object DoubleFor {
    def main(args: Array[String]): Unit = {
        for (x <- 1 until 5) {
            for (y <- 1 until 5) {
                println(x + "x" + y + "=" + x * y)
            }
        }

        println("-------------------------------------------")
        for (x <- 1 until 5; y <- 1 until 5) {
            println(x + "x" + y + "=" + x * y)
        }

        println("-------------------------------------------")
        // for loop에 조건문 활용
        for (i <- (1 to 10) if (i % 2 == 0)) { // 괄호 open-close 유의
            println(i)
        }

        // for 루프에 인덱싱 사용하기
        val days = Array("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday")

        for ((num, index) <- days.zipWithIndex) {
            println(num + ":" + index)
        }
    }
}
