package lectures.part3fp

import scala.util.Random

object Sequences extends App {
  val aSequence = Seq(1, 3, 2, 4, 7, 5)
  println(aSequence)
  println(aSequence.reverse)
  println(aSequence(2))
  println(aSequence ++ Seq(5, 6, 7))
  println(aSequence.sorted)

  val aRange: Seq[Int] = 1 to 10
  aRange.foreach(println)

  (1 to 10).foreach(x => println("Hello"))

  //list (sealed)
  //LinearSeq head, tail isEmpty are fast => O(1)
  // most operations are O(n)

  val aList = List(1, 2, 3)
  val prepended = 42 +:  aList :+ 89 // same as ::.apply
  println(prepended)

  val apples = List.fill(5)("apple")
  println(apples)

  println(aList.mkString("-|-"))

  //Array
  val numbers = Array(1, 2, 3, 4)
  val threeElements = Array.ofDim[String](3)
threeElements.foreach(println)

  //mutate
  numbers(2) = 0 //syntax sugar for numbers.update(2, 0)
  println(numbers.mkString(" "))

  val numbersSeq: Seq[Int] = numbers //implicit conversions
  println(numbersSeq)

  //vectors
  /* EFFECTIVE CONSTANT READ AND WRITE : O(log32(n))
  fast append and prepend
  implemented as a fixed branch trie (branch factor 32)
  good performance for large sizes
   */
  val aVector: Vector[Int] = Vector(1, 2, 3)
  println(aVector)

  // vector vs list

  val maxRuns = 1000
  val maxCapacity = 1000000
  def getWriteTime(collection: Seq[Int]): Double = {
    val r = new Random
    val times = for {
      it <- 1 to maxRuns
    } yield  {
      val currentTime = System.nanoTime()
      collection.updated(r.nextInt(maxCapacity), r.nextInt)
      System.nanoTime() - currentTime
    }
    times.sum * 1.0 / maxRuns
  }

  val numbersList = (1 to maxCapacity).toList
  val numbersVector = (1 to maxCapacity).toVector

  println(getWriteTime(numbersList))
  println(getWriteTime(numbersVector))


}
