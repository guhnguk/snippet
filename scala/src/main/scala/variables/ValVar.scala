package main.variables

object ValVar {
    def main(args: Array[String]): Unit = {
        var a = "I am a variable"
        val b = "I am a final variable"

        a = "Changeable?"
        // b = "Changeable?"
        println(a)

        var ia: Int = 5
        var ib = ia

        ia = 10
        println(ia)
        println(ib)
    }
}
