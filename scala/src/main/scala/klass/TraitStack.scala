package main.klass

object TraitStack {
    def main(args: Array[String]): Unit = {
        val robot = new TaekwonV
        println(robot.shoot)
    }
}

class TaekwonV extends Robot with M16 with Bazooka with Daepodong

abstract class Robot {
    def shoot = "Robot shoot"
}

trait M16 extends Robot {
    override def shoot = "M16 shoot"
}

trait Bazooka extends Robot {
    override def shoot = "Bazooka shoot"
}

trait Daepodong extends Robot {
    override def shoot = "Daepodong shoot"
}