package main.variables

object TypeVariable {
    def main(args: Array[String]): Unit = {
        type Name = String
        type Person = (String, Int)
        type FType = String => Int

        val name: Name = "Ryan"
        val person: Person = ("Ryan", 43)
        val f: FType = text => text.toInt

        println(name)
        println(person)
        println(person._1)
        println(person._2)
        println(f)
    }
}
