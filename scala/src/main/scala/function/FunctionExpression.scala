package main.function

object FunctionExpression {

    def calc(f: Int => Int, start: Int, end: Int) = {
        def loop(index: Int, sum: Int): Int = {     // 재귀 함수
            if (index > end) sum                    // 인덱스가 끝 값보다 크면 sum을 반환
            else loop(index + 1, f(index) + sum)    // 아니면 계속 더합니다.
        }

        loop(start, 0)
    }

    def main(args: Array[String]): Unit = {
        val result = calc(x => x * x, 2, 5)
        println(result)
    }
}
