package lectures.part3fp

object MapFlatmapFilterFor extends App{
  val list = List(1, 2, 3)
  println(list.head)
  println(list.tail)

  println(list.map(_ + 1))
  println(list.map(_ + "is a number"))

  println(list.filter(_ % 2 == 0))

  val toPair = (x: Int) => List(x, x + 1)
 println(list.flatMap(toPair))

  val numbers = List(1, 2, 3, 4)
  val chars = List('a', 'b', 'c', 'd')
  val colors = List("black", "white")
  // List("a1", "a2" ..."d4")
 val result =  chars.flatMap(character => numbers.filter(_ % 2 == 0).flatMap(value => colors.map(color => "" + character + value + color)))
  println(result)

  list.foreach(println)

  val forCombinations = for {
    n <- numbers if n % 2 == 0
    c <- chars
    color <- colors
  } yield "" + c + n + "-" + color
  println(forCombinations)

  for {
    n <- numbers
  } println(n)

  //syntax overload
  list.map { x =>
    x * 2
  }

}
