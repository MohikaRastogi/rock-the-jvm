package lectures.part2oop

object OOBasics extends App {
  private val person = new Person("Mohika", 24)
  println(person.name)
  println(person.someValue)
  person.greet("John")
  person.greet()
  val author = new Writer("Harper", "Lee",1926)
  val novelOne = new Novel("Go Set A Watchman", 2015, author)
  println(novelOne.authorAge)
  println(novelOne.isWrittenBy(author))
  private val count = new Counter(0)
 println(count.increment)
  println(count.increment(2))
  println(count.decrement)
  println(count.decrement(2))
}

//class parameters are not fields or members we can make then by defining type val or var to them
// if not we cannot access them as person.age or person.name
class Person(val name: String, val age: Int) {
  //body
  val someValue = 4
  println(2 + 4)

  //a simple method
  def greet(name: String): Unit = println(s"${this.name} says hi to $name")

  //overloading
  def greet(): Unit = println(s"$name says Hi")
}

//exercise

class Writer(val firstName: String, val surname: String, val yearOfBirth: Int){
  def getFullName(): String = firstName.concat(surname)
}

class Novel(val nameOfNovel: String,val yearOfRelease: Int,val author: Writer){
  def authorAge(): Int = {
    yearOfRelease - author.yearOfBirth
  }
  def isWrittenBy(author: Writer): String = author.getFullName()

  def copy(newYearOfRelease: Int): Novel = new Novel(nameOfNovel,newYearOfRelease,author)
}

class Counter(val count: Int) {
  def increment = new Counter(count + 1)
  def decrement = new Counter(count - 1)

  def increment(valueToAdd: Int):Counter = {
    if(valueToAdd <= 0)
      this
      else
    increment.increment(valueToAdd - 1)
  }
  def decrement(valueToSubtract: Int): Counter = {
    if(valueToSubtract <= 0)
      this
    else
      decrement.decrement(count - valueToSubtract)
  }
}

