package main.patternmaching

object MatchFunction {

    def matchFunction(input: Any): Any = input match {
        case 100 => "hundred"
        case "hundred" => 100
        case etcNumer: Int => "Input value is just 100 and integer."
        case _ => "etc"
    }

    def main(args: Array[String]): Unit = {
        println(matchFunction(100))
        println(matchFunction("hundred"))
        println(matchFunction(1000))
        println(matchFunction(1000.5))
        println(matchFunction("thousand"))
    }
}
