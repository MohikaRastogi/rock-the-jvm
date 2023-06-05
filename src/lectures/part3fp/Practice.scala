package lectures.part3fp

object Practice extends App {
  val str = "abcabdfra"

  val c = str.flatMap(charValue => List(charValue))
  println(c)

  def findDuplicates(list: List[Int]): List[Int] = {
    list match {
      case Nil => List()
      case head :: Nil => List(head)
      case head :: tail => head :: findDuplicates(tail.dropWhile(_ == head))
    }
  }

  println(findDuplicates(List(1, 1, 2, 3, 3, 3, 4, 2, 1, 1, 4, 4, 5, 5)))

  def getPrime(list: List[Int]): List[Int] = {
    list.filter(num => isPrime(num))

  }

  def isPrime(num: Int): Boolean = {
    val countDivisors = (1 to num).filter(divisors => num % divisors == 0)
    if (countDivisors.length > 2)
      false
    else
      true
  }

  println(getPrime(List(1, 2, 3, 4, 5)))

  def swap(numOne: Int, numTwo: Int,time: Int = 1): Unit = {
    if(time == 0)
    println(numOne,numTwo)
    else
    swap(numTwo,numOne, time - 1)
  }
  swap(4,5)
}
