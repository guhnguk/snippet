package main.patternmaching

object MatchKlass {


    def main(args: Array[String]): Unit = {
        val person1 = Person("Kim", 43, "Group leader")
        val person2 = Person("Song", 29, "Jheen Leader")
        val person3 = Person("Lee", 54, "Team leader")

        matchAndHi(person1)
        matchAndHi(person2)
        matchAndHi(person3)
    }

    case class Person(name: String, age: Int, rank: String)

    def matchAndHi(person: Person) = person match {
        case Person("Kim", 43, "Group leader") => println("Welcome to group leader")
        case Person("Song", 29, "Jheen Leader") => println("Welcome to Jheen leader")
        case Person("Lee", age, r) if age < 25 => println("Welcome to " + r)
        case _ => println("Not match")
    }
}

