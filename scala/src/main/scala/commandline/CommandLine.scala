package main.commandline

object CommandLine {
    def main(args: Array[String]): Unit = {
        print("Input message ... ")
        val a = scala.io.StdIn.readLine
        println("Your input message is " + a)
    }
}
