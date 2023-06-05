package lectures.part3fp

object TuplesAndMaps extends App{
val aTuple = (2, "hello, Scala")
  println(aTuple._1)
  println(aTuple.copy(_2 = "goodbye Java"))
  println(aTuple.swap)

  val aMap: Map[String, Int] = Map()
  val phonebook = Map(("Jim", 555), ("Daniel", 789)).withDefaultValue(-1)
  println(phonebook)

  println(phonebook.contains("Jim"))
  println(phonebook("Jim"))
  println(phonebook("Mary"))

  val newPair = "Mary" -> 678
  val newPhonebook = phonebook + newPair
  println(newPhonebook)

  println(phonebook.map(pair => pair._1.toLowerCase -> pair._2))

  //filterKeys and Mapvalues are more useful for map

  println(phonebook.filterKeys(aKey => aKey.startsWith("J")))
  println(phonebook.mapValues(aValue => "0245-" + aValue))
  println(phonebook.toList)
  println(List(("Daniel", 555), ("Mary", 678)).toMap)
  val names = List("Bob", "James", "Angela", "Mary", "Daniel", "Jim")
  println(names.groupBy(name => name.charAt(0)))

  //experiment
  val employee = Map("Jim" -> 222, "JIM" -> 333)
  println(employee.map(someValue => someValue._1.toLowerCase -> someValue._2))
}
