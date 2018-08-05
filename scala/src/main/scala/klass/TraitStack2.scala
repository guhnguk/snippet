package main.klass

object TraitStack2 {
    def main(args: Array[String]): Unit = {
        val robot = new SuperTaekwonV
        println(robot.shoot)
    }
}

class SuperTaekwonV extends AnotherRobot with AnotherM16 with AnotherBazooka with AnotherDaepodong

abstract class AnotherRobot {
    def shoot = "[1]Robot shoot"
}

trait AnotherM16 extends AnotherRobot {
    override def shoot = super.shoot + "[2]M16 shoot"
}

trait AnotherBazooka extends AnotherRobot {
    override def shoot = super.shoot + "[3]Bazooka shoot"
}

trait AnotherDaepodong extends AnotherRobot {
    override def shoot = super.shoot + "[4]Daepodong shoot"
}