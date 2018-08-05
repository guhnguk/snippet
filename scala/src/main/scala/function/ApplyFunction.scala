package main.function

object ApplyFunction {
    def main(args: Array[String]): Unit = {
        val someValue = new SomeKlass
        println("------------------------")
        println(someValue(10))          // apply function invoke
        println(someValue.apply(10))
        println(someValue.method(10))
        println("------------------------")
        println(someValue("TEST"))      // apply function invoke
        println(someValue.apply("TEST"))
        println(someValue.method("TEST"))

    }

    class SomeKlass {
        def apply(m: Int) = method(m)
        def method(m: Int) = m + m

        def apply(m: String) = method(m)
        def method(m: String) = m + ", " + m

    }


}
