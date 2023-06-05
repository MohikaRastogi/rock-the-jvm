package lectures.part1basics

object Expressions extends App {
  val computeValue = 1 + 2 * 3 //operator precedence is followed
  println(computeValue)

  var aVariable = 3
  aVariable += 2

  //Instructions vs Expressions
  val aCondition = true
  val aConditionedValue = (if (aCondition) 5 else 3)
  println(aConditionedValue) //prints  ()

  //Code Block
  val aCodeBlock = {
    val number1 = 2
    val number2 = number1 + 1

    if (number2 > 2) "hello" else "goodbye"
  }
  //values used/declared inside a code block cannot be used outside that particular block
  // val number3 = number2 +1  here number2 is not a value outside the block it asks to create a new val type or ar or an object

  val someValue = {
    2 < 3
  }
  println(someValue)

  val someOtherValue = {
    if (someValue) 239 else 986
    42
    //println(s"my name is $name")
  }
  println(someOtherValue)

  val aWeirdValue = (aVariable = 3)
  println(aWeirdValue)
  val name = "ayushi"
  println(s"Hello, $name, how are you?")
  val a = 000.25
  println(raw"$name says the number is $a\nOkay, bye")
  println(s"$name says the number is $a\nOkay, bye")
  println(f"The number is $a%.3f")

  var statement: String = "hello world\n scala beginners"
  println(raw"$statement says that we are lear")


  val name2 = "Ayushi"

   println(s"Hello, $name2, how are you?")
  println(s"Hello, 2+3 is ${2 + 3}")

  println(s""""$name2"""")
  println(raw"""
   Inside this block you can put "as many" quotes as you "want" and even "${5 + 7}" interpolate inside the quotes
""")


}

