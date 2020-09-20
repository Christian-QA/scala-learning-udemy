package lectures.part4pm

import exercises.{Cons, Empty}
import lectures.part2oop.Generics.{MyList, animalList}
import lectures.part3fp.Sequences.aList

object AllThePatterns {

  //Udemy: Lecture - All The Patterns

  // 1 - constants
  val x: Any = "Scala"
  val constants = x match {
    case 1 => "a number"
    case "Scala" => "THE Scala"
    case true => "The Trush"
    case AllThePatterns => "A singleton object"
  }

  // 2 - match anything
  // 2.1 wildcard
  val matchAnything = x match {
    case _ =>
  }

  // 2.2 variable
  val matchAVariable = x match {
    case something => s"I've found $something"
  }

  // 3 - tuples
  val aTuple = (1,2)
  val matchATuple = aTuple match {
    case (1, 1) =>
    case (something, 2) => s"I've found $something"
  }

  val nestedTuple = (1, (2, 3))
  val matchANestedTuple = nestedTuple match {
    case (_, (2, v)) =>
  }
  // PMs can be NESTED

  // 4 - case classes - constructor pattern
  // PMs can be nested with case classes as well
//  val aList: MyList[Int] = Cons(1, Cons(2, Empty))
//  val matchAList = aList match {
//    case Empty =>
//    case Cons(head, tail) =>
//  }

  // 5 - list patterns
  val aStandardList = List(1,2,3,42)
  val standardListMatching = aStandardList match {
    case List(1, _, _, _) => // Extractor - advanced Scala
    case List(1, _*) => // list of arbitrary length - advanced Scala
    case 1 :: List(_) => // Infix pattern
    case List(1,2,3) :+ 42 => // infix pattern
  }

  // 6 - Type specifiers
  val unknown: Any = 2
  val unknownMatch = unknown match {
    case list: List[Int] => //Explicit type specifier
    case _ =>
  }

  // 7 - Name binding
  val nameBindingMatch = aList match {
    case nonEmptyList @ Cons(_, _) => // name binding => use the name later (here)
    case Cons(1, rest @ Cons(2, _)) => // name binding inside nested patterns
  }

  // 8 - multi-patterns
  val multipattern = aList match {
    case Empty | Cons(0, _) => // Compound pattern (multi-pattern)
  }

  // if 9 - if guards
  val secondElementSpecial = aList match {
    case Cons(_, Cons(specialElement, _)) if specialElement % 2 == 0 =>
  }

  // ALL.

  /*
    Question - What does the below PM return
   */

  val numbers = List(1,2,3)
  val numbersMatch = numbers match {
    case listOfStrings: List[String] => "a list of strings" // Returns this. case matches against a list of Strings, a JVM trick question.
    case listOfNumbers: List[Int] => "a list of numbers" // This is called Type Erasure, a known issue which IntelliJ warns you about
    case _ =>
  }
}
