package exercises

abstract class MyListTwo[+A] {
  def head: A
  def tail: MyListTwo[A]
  def isEmpty: Boolean
  def add[B >: A](elementToAdd: B): MyListTwo[B]
  def printElements: String
  override def toString: String = "[" + printElements + "]"
  def map[B](transformer: A => B): MyListTwo[B]
  def flatMap[B](transformer: A => MyListTwo[B]): MyListTwo[B]
  def filter(predicate: A => Boolean): MyListTwo[A]
  def ++[B >: A](list: MyListTwo[B]): MyListTwo[B]

  def foreach(f: A => Unit): Unit

  def sort(compare: (A, A) => Int): MyListTwo[A]

  def zipWith[B, C](list: MyListTwo[B], zip:(A, B) => C): MyListTwo[C]

  def fold[B](start: B)(operator: (B, A) => B): B
}

case object Empty extends MyListTwo[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: MyListTwo[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
   def add[B >: Nothing](elementToAdd: B): MyListTwo[B] = new Cons(elementToAdd, Empty)
  def printElements: String = " "
  def map[B](transformer: Nothing => B): MyListTwo[B] = Empty
  def flatMap[B](transformer: Nothing => MyListTwo[B]): MyListTwo[B] = Empty
  def filter(predicate: Nothing => Boolean): MyListTwo[Nothing] = Empty
  def ++[B >: Nothing](list: MyListTwo[B]): MyListTwo[B] = list

  def foreach(f: Nothing => Unit): Unit = ()

  def sort(compare: (Nothing, Nothing) => Int) = Empty

   def zipWith[B, C](list: MyListTwo[B], zip: (Nothing, B) => C): MyListTwo[C] =
     if(!list.isEmpty)
       throw new RuntimeException("A List cannot be zipped with empty list ")
       else
       Empty

   def fold[B](start: B)(operator: (B, Nothing) => B): B = start
}

case class Cons[+A](headValue: A, tailList: MyListTwo[A]) extends MyListTwo[A] {
  def head: A = headValue
   def tail: MyListTwo[A] = tailList
   def isEmpty: Boolean = false
   def add[B >: A](elementToAdd: B): MyListTwo[B] = new Cons(elementToAdd, this)
  def printElements(): String = {
    if (tailList.isEmpty)
      "" + headValue
    else
      headValue + " " + tailList.printElements
  }

  //def ++[B >: A](list: MyListTwo[B]): MyListTwo[B] = new Cons(headValue, tailList ++ list)
  def filter(predicate: A => Boolean): MyListTwo[A] = {
    if (predicate(headValue))   //predicate.apply
      new Cons(headValue, tailList.filter(predicate))
    else
      tailList.filter(predicate)
  }
  def map[B](transformer: A => B): MyListTwo[B] = {
    new Cons(transformer(headValue), tailList.map(transformer))
  }
  def ++[B >: A](list: MyListTwo[B]): MyListTwo[B] = new Cons(headValue, tailList ++ list)

  def flatMap[B](transformer: A => MyListTwo[B]): MyListTwo[B] = {
     transformer(headValue) ++ tailList.flatMap(transformer)
  }

  def foreach(f: A => Unit): Unit = {
    f(headValue)
    tailList.foreach(f)
  }

  def sort(compare: (A, A) => Int): MyListTwo[A] = {
    def insert(x: A, sortedList: MyListTwo[A]): MyListTwo[A] = {
      if(sortedList.isEmpty) new Cons(x, Empty)
      else if(compare(x, sortedList.head) <= 0) new Cons(x, sortedList)
      else new Cons(sortedList.head, insert(x, sortedList.tail))
    }

    val sortedTail = tailList.sort(compare)
    insert(headValue,sortedTail)
  }

  def zipWith[B, C](list: MyListTwo[B], zip: (A, B) => C): MyListTwo[C] =
    if(list.isEmpty)
      throw new RuntimeException("LISTS are of different lengths")
    else new Cons(zip(headValue, list.head), tailList.zipWith(list.tail, zip))

  def fold[B](start: B)(operator: (B, A) => B): B = {
    tailList.fold(operator(start, headValue))(operator)
  }


}

//trait MyPredicate[-T] {
//  def test(element: T): Boolean
//}

//

object listTest extends App {
  //  val list = new Cons(1,Empty)
  //  val anotherList = new Cons(1,new Cons(2,new Cons(3,Empty)))
  //  println(list.head)
  //  println(anotherList.tail.head)
  //  println(anotherList.add(4).head)
  //  println(list.isEmpty)
  //
  //  println(list.toString)
  val listOfIntegers: MyListTwo[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val copyListOfIntegers: MyListTwo[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val listOfStrings: MyListTwo[String] = new Cons("Hello", new Cons("Scala", Empty))
  val anotherListOfIntegers: MyListTwo[Int] = new Cons(4, new Cons(5, Empty))

  println(listOfIntegers.toString)
  println(listOfStrings.toString)

  println(listOfIntegers.map(element => element % 2 == 0).toString)

  println(listOfIntegers.filter(element => element % 2 == 0).toString)

  println((listOfIntegers ++ anotherListOfIntegers).toString)

  println((listOfIntegers.flatMap(element => new Cons(element + 1, Empty))).toString)

  println(listOfIntegers == copyListOfIntegers)

  listOfIntegers.foreach(println)

  println(listOfIntegers.sort((x, y) => y - x))

  println(anotherListOfIntegers.zipWith[String, String](listOfStrings,_ + "-" + _))

  println(listOfIntegers.fold(0)(_ + _))

  val combinations = for {
    n <- listOfIntegers
    string <- listOfStrings
  } yield n + "-" + string
  println(combinations)
}
