package lectures.part2oop

object MethodNotations extends App {
  class Person(val name: String, favoriteMovie: String, val age: Int = 0) {
    def likes(movie: String): Boolean = {
      movie == favoriteMovie
    }

    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"

    def unary_! : String = s"$name all"

    def isAlive: Boolean = true

    def apply(): String = s"Hi, my name is $name and i like the movie $favoriteMovie"
    def apply(times: Int): String = s"$name has watched $favoriteMovie $times times"
    def +(nickname: String): Person = new Person(s"$name ($nickname)", favoriteMovie)

    def unary_+(): Person = new Person(name, favoriteMovie, age + 1)

    def learns(thing: String) = s"$name is learning $thing"
    def learnsScala = this learns "Scala"

  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  println(mary likes "Inception")

  val tom = new Person("Tom", "Fight Club")
  println(mary + tom)
  println(mary.+(tom))

  println(1 + 2)
  println(1.+(2))

  val x = -1 //equal to 1.unary_-
  val y = 1.unary_-

  println(!mary)
  println(mary.unary_!)

  println(mary.isAlive)
  println(mary isAlive)

  println(mary.apply())
  println(mary())

  println((mary + "the rockstar").apply())
  println((+mary).age)

  println(mary learnsScala)
  println(mary(10))
}
