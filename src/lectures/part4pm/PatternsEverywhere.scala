package lectures.part4pm

object PatternsEverywhere extends App {

  // Big Idea #1
  try {
    // code
  } catch {
    case e: RuntimeException => "runtime"
    case npe: NullPointerException => "npe"
    case _ => "something else"
  }

  // catches are actually matches

  // Big Idea #2
  val list = List(1,2,3,4)
//  val evenOnes for {
//    x <- list if x % 2 == 0 // ?!
//  } yield 10 * x

  // generators are also based on PATTERN MATCHING
  val tuples = List((1,2), (3,4))
  val filterTuples = for {
    (first, second) <- tuples
  } yield first * second
  // case classes, :: operators, ...

  // Big Idea #3
  val tuple = (1,2,3)
  val (a,b,c) = tuple
  println(b)
  // multiple value definitions based on PATTERN MATCHING

  val head :: tail = list
  println(head) // Head and tail are bound to the memory of list
  println(tail)

  // Big Idea #4
  // partial function
  val mappedList = list.map {
    case v if v % 2 == 0 => v + " is even"
    case 1 => "the one"
    case _ => "something else"
  }

  val mappedList2 = list.map { x => x match {
    case v if v % 2 == 0 => v + " is even"
    case 1 => "the one"
    case _ => "something else"
  }
  }
  println(mappedList)
}
