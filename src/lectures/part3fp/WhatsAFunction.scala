package lectures.part3fp

object WhatsAFunction extends App {
val doubler = new MyFunction[Int, Int] {
  override def apply(element: Int): Int = element * 2
}
  println(doubler(2))

  val stringToIntConvertor = new Function[String, Int] {
    override def apply(string: String): Int = string.toInt
  }

  println(stringToIntConvertor("3") + 4)

  val adder = new Function2[Int, Int, Int] {
    override def apply(a: Int, b: Int): Int = a + b
  }
  println(adder(4,5))

  def concatenate: (String, String) => String = new Function2[String, String, String] {
    override def apply(stringOne: String, stringTwo: String): String = stringOne + stringTwo
  }
  println(concatenate("my", "name"))

  val superAdder: Function1[Int, Function1[Int, Int]] = new Function1[Int, Function1[Int, Int]] {
    override def apply(numberOne: Int): Function1[Int, Int] = new Function1[Int, Int] {
      override def apply(numberTwo: Int): Int = numberOne + numberTwo
    }
  }

  val adderThree = superAdder(3)
  println(adderThree(4))
  println(superAdder(3)(4))  //curried function

}
trait MyFunction[A, B] {
  def apply(element: A): B
}
