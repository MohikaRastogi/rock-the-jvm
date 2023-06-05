package lectures.part2oop

object Objects extends App {
  object Person {
    val N_EYES = 2
    def canFly: Boolean = false
    //factory method
    def apply(mother: Person, father: Person): Person = new Person("child")
  }
  class Person(val name: String) {

  }

  println(Person.N_EYES)
  println(Person.canFly)

  val mary = Person
  val john = Person
  println(mary == john) //true - only one instance as Singleton object
  val personOne = Person
  val personTwo = Person
  val firstPerson = new Person("mary")
  val secondPerson = new Person("john")
  println(firstPerson == secondPerson) // false
  println(personOne == personTwo) //true
  val child = Person(firstPerson, secondPerson)  // same as Person.apply


}
