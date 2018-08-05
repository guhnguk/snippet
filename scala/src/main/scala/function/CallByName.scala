package main.function

object CallByName {

    def dropship(n: Int) = {
        println("드랍쉽 준비 합니다.")
        println(n + "명 탑승했습니다.")
    }

    def newdropship(n: => Int) = {  // CALL-BY-NAME
        println("드랍쉽 준비 합니다.")
        println(n + "명 탑승했습니다.")
    }

    def people(n: Int) = {
        println("탑승 수속을 시작합니다.")
        n
    }

    def main(args: Array[String]): Unit = {
        dropship(people(5)) // people 호출 --> 리턴 값 --> dropship 전달 --> 출력
        println("--------------------------")
        newdropship(people(5)) // newdropship 호출 --> 내부에서 people 호출 --> 리턴 값 --> 출력
    }
}
