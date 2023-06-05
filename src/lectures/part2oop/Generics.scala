package lectures.part2oop

object Generics extends App {
  class MyList[A] {

  }
  class MyMap[Key, Value]

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  object MyList {
    def empty[A]: MyList[A] = ???
  }
  val emptyListOfIntegers = MyList.empty[Int]

  class Animal
  class Cat extends Animal
  class Dog extends Animal

  //List[Cat] extends List[Animal] = Covariance
  class CovariantList[+A]
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]

  // list[cat] list[dog] are two separate things = INVARIANCE
  class InvariantList[A]
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]

  // never- Contravariant
  class ContravariantList[-A]
  val contravariantList: ContravariantList[Cat] = new ContravariantList[Animal]

  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]
}
