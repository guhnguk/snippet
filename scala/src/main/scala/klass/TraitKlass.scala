package main.klass

object TraitKlass {
    def main(args: Array[String]): Unit = {
        val flyingWhale = new Animal
        flyingWhale.swim
        flyingWhale.fly
    }

    class Animal extends Flying with Swimming

    trait Swimming {
        def swim = println("I'm swimming in the pool.")
    }

    trait Flying {
        def fly = println("I can fly.")
    }

    trait Running {
        def running = println("I am running.")
    }

    trait Eating {
        def eat
    }
}


