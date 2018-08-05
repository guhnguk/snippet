package main.klass

object InheritanceTrait {
    def main(args: Array[String]): Unit = {
        val pig = new Animal2
        pig.eat
    }

    class Animal2 extends Eating {
        //override def eat = println("eating...")
        //super.eat

        def eat = println("eating...")
    }

    trait Swimming {
        def swim = println("swimming...")
    }

    trait Flying {
        def fly = println("flying...")
    }

    trait Running {
        def run = println("running...")
    }

    trait Eating {
        //def eat = println("TEST")
        def eat
    }
}
