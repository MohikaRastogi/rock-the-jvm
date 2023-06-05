package lectures.part1basics

object Recursion extends App {
  def factorial(number: Int):  Int = {
    if(number <= 0)
      1
    else
      number * factorial(number - 1)
  }
}
