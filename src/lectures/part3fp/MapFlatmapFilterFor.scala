package lectures.part3fp

object MapFlatmapFilterFor extends App {

  //Udemy: Lecture - Map, Flatmap, Filer and for-comprehensions

  val list = List(1,2,3)
  println(list.head)

  // map
  println(list.map(_ + 1))
  println(list.map(_ + " is a number"))

  // filter
  println(list.filter(_ % 2 == 0))

  // flatMap
  val toPair = (x: Int) => List(x, x+1)
  println(list.flatMap(toPair))

  /// Exercise
  // print all combinations between two lists
  val numbers = List(1,2,3,4)
  val chars = List('a','b','c','d')
  val colours = List("black", "white")
  // List("a1", "a2"... "d4")

  // "iterating"
  val combinations = numbers.flatMap(n => chars.flatMap(c => colours.map(colour => "" + c + n + colour)))
  println(combinations)

  // foreach
  list.foreach(println)

  // for-comprehensions
  val forCombinations = for {
    n <- numbers
    c <- chars
    colour <- colours
  } yield "" + c + n + "" + colour
  println(forCombinations)
  // This is identical to the flatMap iteration style used above under "iterating", only far more human readable

  val forCombinations2 = for {
    n <- numbers if n % 2 == 0
    c <- chars
    colour <- colours
  } yield "" + c + n + "" + colour
  println(forCombinations2)
  // Identical to: val combinations = numbers.filter(_ % 2 == 0).numbers.flatMap(n => chars.flatMap(c => colours.map(colour => "" + c + n + colour)))

  for {
    n <- numbers
  } println(n)

  // Syntax Overload
  list.map { x =>
    x * 2
  }

  /*
    Exercise
    A small collection of at most ONE element - Maybe[+T]
      - map, flatMap, filter

      Can be found in the exercises package as an abstract class called Maybe
   */

}
