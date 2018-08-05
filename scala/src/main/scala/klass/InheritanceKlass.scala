package main.klass

object InheritanceKlass {
    def main(args: Array[String]): Unit = {
        val richUser = new PaidUser("Rachael", 20, 'M', 10000)
        richUser.sayName
        richUser.showMoney
    }
}


class User(name: String, age: Int, sex: Char) {
    val sayName = println("My name is " + name)
}

class PaidUser(name: String, age: Int, sex: Char, money: Int) extends User(name, age, sex) {
    val showMoney = println("I have " + money)
}