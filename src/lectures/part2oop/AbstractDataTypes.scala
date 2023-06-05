package lectures.part2oop

object AbstractDataTypes extends App{

  abstract class Animal {
    val creatureType: String = "wild"
    def eat: Unit
  }
  //abstract classes cannot be instantiated
 // val animal = new Animal //error

  class Dog extends Animal {
    override val creatureType: String = "Canine"
    override def eat: Unit = println("crunch crunch")
  }

  trait Carnivore {
    def eat(animal: Animal): Unit
    val preferredMeal: String = "croc"
  }

  trait ColdBlooded
  class Crocodile extends Animal with Carnivore with ColdBlooded {
    override val creatureType: String = "croc"
    def eat: Unit = println("crocodile eats" )
    def eat(animal: Animal): Unit = println(s"I'm a croc and I am eating ${animal.creatureType}")
  }
  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)

}
