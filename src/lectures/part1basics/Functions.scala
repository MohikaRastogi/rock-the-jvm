package lectures.part1basics

object Functions extends App {
  def aFunction(name: String, age: Int): String = {
    name + " " + age
  }

  println(aFunction("Mohika", 24))

  //Repeated Functions i.e. using function itself to form a loop

  def aRepeatedFunction(aString: String, num: Int): String = {
    if (num == 1)
      aString
    else
      aString + aRepeatedFunction(aString, num - 1)
  }

  println(aRepeatedFunction("hello", 12))

  def factorial(factNumber: Int): Int = {
    if (factNumber <= 1)
      1
    else
      factNumber * factorial(factNumber - 1)

  }

  println(factorial(5))

  def fibonacci(Nth_Number: Int): Int = {
    if (Nth_Number <= 2)
      1
    else
      fibonacci(Nth_Number - 1) + fibonacci(Nth_Number - 2)
  }

  println(fibonacci(1))

  def checkPrime(num: Int): Boolean = {
    def checkPrimeUntil(temporaryLoop: Int): Boolean =
      if (temporaryLoop <= 1) true
      else num % temporaryLoop != 0 && checkPrimeUntil(temporaryLoop - 1)

    checkPrime(num / 2)
  }

  println(checkPrime(5))
}