package main.io

import scala.io.StdIn.readLine
import java.io.File
import java.io.PrintWriter

object FileIOTest {
    def main(args: Array[String]): Unit = {
        val fileName = "FileIOTest.txt"
        val input = readLine("Input message")

        val writer = new PrintWriter(new File(fileName))
        writer.write(input)
        writer.close

        println("Input message is ["+ input + "] onto [" + fileName + "]")
    }
}
