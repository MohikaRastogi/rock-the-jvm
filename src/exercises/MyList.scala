package exercises

abstract class MyList {

  def getHeadOfList(list: List[Int]): Int
  def getTailOfList(list: List[Int]): List[Int]
  def isEmpty(list: List[Int]): Boolean
  def addElementAtEndOfList(list: List[Int], elementToBeAdded: Int): List[Int]

  override def toString: String = super.toString
}
class ListImplementation extends MyList {
  override def getHeadOfList(list: List[Int]): Int = {
    list match {
      case head :: Nil => head
      case head :: tail => head
      case Nil => throw new NoSuchElementException("empty list")
      case _ => throw new Exception("an unknown error occured")
    }
  }
  override def getTailOfList(list: List[Int]): List[Int] ={
    list match {
      case head :: Nil => Nil
      case head :: tail => tail
      case Nil => throw new NoSuchElementException("empty list")
      case _ => throw new Exception("unknown error occured")
    }
  }

  override def isEmpty(list: List[Int]): Boolean = {
    list match {
      case head :: Nil => false
      case head :: tail => false
      case Nil => true
      case _ => throw new Exception("an error occured")
    }
  }

  override def addElementAtEndOfList(list: List[Int], elementToBeAdded: Int): List[Int] = {
    list match {
      case head :: Nil => list :+ elementToBeAdded
      case head :: tail => list :+ elementToBeAdded
      case Nil => throw new IllegalArgumentException("empty list found")
      case _ => throw new Exception("an error occured")
    }
  }
}

object listImplementation extends App {
  val listImplementation = new ListImplementation
  val list = List(1, 2, 3, 4, 5)
  println(listImplementation.getHeadOfList(list))
  println(listImplementation.getTailOfList(list))
    println(listImplementation.addElementAtEndOfList(list, 6))
    println(listImplementation.isEmpty(list))
    println(listImplementation.toString)
}
