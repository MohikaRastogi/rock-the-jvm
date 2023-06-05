package lectures.part1basics

object StringOps extends App
{
  val inputString: String = "Hello i am new to Scala"
  val aNumberString: String = "55"
  //println(inputString.toInt) throws NumberFormatException
  println(inputString.charAt(4))
  println("Hello".compareTo("Hello"))
  println("Hello".compareTo("hello"))
  println(inputString.length)
  println(inputString.toLowerCase)
  println(inputString.toUpperCase)
  println(inputString.concat("!!"))
  println(inputString.split(" "))
  println(inputString.startsWith("Hello"))
  println(inputString.endsWith("Scala"))
  println(aNumberString.toInt)
  println(inputString.indexOf("o"))
  println(inputString.lastIndexOf("a"))
  println(inputString.replace("Hello", "Hello!!"))
  println(inputString.take(4))
  println(inputString.reverse)

// String Interpolation
  //s interpolation
  val name = "yourName"
  val age = "yourAge"
  val stringStatement = s"My name is $name and age is $age"
  val anotherStatement = s"My full name is ${name :+ "surname" } and age is ${age + 1}"

  //f interpolation
  private val rupees = 500.587f
  val balance = f"I will be left with $rupees%.2f after deducting"
  println(balance)

  //raw interpolator
  println("escape to new line \n without using raw interpolator here")
  println(raw"cannot escape to new line using \n here because of raw")

  val escape = raw"cannot escape to \n newline"
  println(escape)
  val list = List(1,2,3,4)
}



