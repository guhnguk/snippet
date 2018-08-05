package main.modifier

object ModifierTest {
    def main(args: Array[String]): Unit = {
        println(MyObject1.mb)
        println(MyObject2.mb)

    }
    object MyObject1 {
       private def ma = {}
        def mb = { "mb" }
    }

    object MyObject2 {
        // compile error
        // MyObject1.ma

        val mb = MyObject1.mb
    }

    class MyObject1 {
        val ca = MyObject1.ma
        val cb = MyObject1.mb
    }
}
