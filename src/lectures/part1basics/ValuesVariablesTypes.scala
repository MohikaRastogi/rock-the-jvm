package lectures.part1basics

object ValuesVariablesTypes extends App {
val demoValue: Int = 42
  println(demoValue)
  // val are immutable
  //demoValue = 30
  val demoValue2 = 32 // works fine as type inference is used

  //if type is explicitly mentioned then make sure that you provide right type of value on right hand side
  // val demoVals : Int = "hello scala"


}
