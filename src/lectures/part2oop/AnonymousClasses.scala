package lectures.part2oop

object AnonymousClasses extends App {

  abstract class Animal {
    def eat: Unit
  }
  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("hahah")
  }
  println(funnyAnimal.getClass)

  class Person(name: String) {
    def sayHello: Unit = println(s"hello, my name is $name")
  }
  val jim = new Person("Jim") {
    override def sayHello: Unit = println(s"hi my name is Jim")
  }
}
