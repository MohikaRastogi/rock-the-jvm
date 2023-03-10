package lectures.part1basics

object Expressions extends App {
  val computeValue = 1 + 2 * 3  //operator precedence is followed
  println(computeValue)

  var aVariable = 3
  aVariable += 2

  //Instructions vs Expressions
  val aCondition = true
  val aConditionedValue = (if(aCondition) 5 else 3)
  println(aConditionedValue)   //prints  ()

  //Code Block
  val aCodeBlock= {
    val number1 = 2
    val number2 = number1 + 1

    if(number2 > 2) "hello" else "goodbye"
  }
  //values used/declared inside a code block cannot be used outside that particular block
  // val number3 = number2 +1  here number2 is not a value outside the block it asks to create a new val type or ar or an object

  val someValue = {
    2 < 3
  }
  println(someValue)

  val someOtherValue = {
    if(someValue) 239 else 986
    42
  }
  println(someOtherValue)

  val aWeirdValue = (aVariable = 3)
  println(aWeirdValue)
}
