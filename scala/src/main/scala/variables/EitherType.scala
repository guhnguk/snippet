package main.variables

object EitherType {
    def main(args: Array[String]): Unit = {
        val input = scala.io.StdIn.readLine("Input value ... : ")
        val result: Either[String, Int] = try {
            Right(input.toInt)
        } catch {
            case e: Exception => Left(input)
        }

        println(result.getClass)

    }
}
