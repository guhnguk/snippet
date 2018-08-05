package main.conditionsloops

object ConditionsLoops {
    def main(args: Array[String]): Unit = {
        var x = 20

        if (x > 15 ) {
            println("15보다 큽니다.")
        } else if (x < 15) {
            println("15보다 작습니다.")
        } else {
            println("과연 뭘까요?")
        }

        if (x > 15) println("15보다 큽니다.")

        println("-------------------------------------------")
        println("for문 to 시작")
        for (x <- 1 to 10) { // 10 이하, 10 포함
            println("xd의 값은 " + x)
        }

        println("-------------------------------------------")
        println("for문 until 시작")
        for (x <- 1 until 10) { // 10 미만, 10 미포
            println("xd의 값은 " + x)
        }

        println("-------------------------------------------")
        var a = 0
        println("while문 시작")

        while (a < 20) {
            print(a + ",")
            a = a + 1
        }

        println("\ndo-while 시작")

        var b = 0
        do {
            print(b + ",")
            b = b + 1
        } while (b < 20)
    }
}
