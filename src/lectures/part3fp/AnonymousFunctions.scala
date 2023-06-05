package lectures.part3fp

object AnonymousFunctions extends App {
  val doubler: Int => Int = x => x * 2

  val adder: (Int, Int) => Int = (a: Int, b: Int) => a + b

  val something = () => 3 // no parameter anonymous function
//  println(something) //returns functions
  println(something())

  val stringToInt = { (string: String) =>
    string.toInt
  }

  val niceIncrementer: Int => Int = _ + 1 // equivalent to x => x + 1
  val niceAdder: (Int, Int) => Int =  _ + _ // equal to (a, b) => a + b

  val superAdd = (x: Int) => (y: Int) => x + y
  println(superAdd(3)(4))
}
