package lectures.part2oop

object Inheritance extends App {

  class Animal {
    val creatureType = "wild"

    def eat = println("nomnom") //cannot be private , will become inaccessible
  }

  class Cat extends Animal {
    def crunch = {
      eat
      println("crunch crunch")
    }
  }

  val cat = new Cat
  //cat.eat
  cat.crunch


  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }

  class Adult(name: String, age: Int, idCard: String) extends Person(name, age)

  //  class Dog extends Animal {
  //    override def eat = println("crunch crunch")
  //
  //    override val creatureType: String = "domestic"
  //  }
  class Dog(override val creatureType: String) extends Animal {

    override def eat = {
      super.eat
      println("crunch crunch")
    }
  }

  val dog = new Dog("duke")
  dog.eat
  println(dog.creatureType)

  val anAnimal: Animal = new Dog("K9")
  anAnimal.eat
}
