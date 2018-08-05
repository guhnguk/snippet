package main.klass

object AbstractTrait {
    def main(args: Array[String]): Unit = {
        val pig = new Pig
        pig.eat
        pig.shout
        pig.fly
    }

    class Pig extends Animal with Flying with Eating {
        def shout = println("PigPig")
        def eat = println("EatEat")
    }

    abstract class Animal {
        def shout
    }

    trait Swimming {
        def swim = println("I am swimming...")
    }

    trait Flying {
        def fly = println("I can fly...")
    }

    trait Running {
        def run = println("I am running...")
    }

    trait Eating {
        def eat
    }
}
