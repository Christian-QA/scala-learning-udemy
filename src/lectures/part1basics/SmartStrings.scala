package lectures.part1basics

object SmartStrings extends App {

  ///Udemy: Lecture 8 - Smart Operations on Strings

  val str: String = "Hello, I am learning Scala"

  println(str.charAt(2))
  println(str.substring(5, 12))
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.replace(" ", "-"))
  println(str.toLowerCase())
  println(str.length())

  val aNumberString = "45"
  val aNumber = aNumberString.toInt
  println('a' +: aNumberString :+ 'z')
  println(str.reverse)
  println(str.take(2))

  // Scala-specific: String interpolators
  // S-interpolators
  val name = "Chris"
  val age = 5
  val greeting = s"Hello, my name is $name and I am ${age + 19} years old"
  println(greeting)

  // F-interpolators
  val speed = 52.6f
  val myth = f"$name%s can eat $speed%2.2f burgers per minute"
  println(myth)

  // Raw Interpolator
  println("This is a \n newline")
  println(raw"This is a \n newline") // \n doesn't 'escape'

  val escaped = "This is a \n newline"
  print(raw"$escaped") // Variables do escape

}
