package lectures.part3fp

object WhatsAFunction extends App {

  //Udemy: Lecture - What's a Function, Really?

  // DREAM: Use functions as first class elements
  // PROBLEM: We come from a world of OOP

  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int) : Int = element * 2
  }
  println(doubler(2))

  // function types = Function1[A, B]
  val stringToIntConverter = new Function[String, Int] {
    override def apply(string: String): Int = string.toInt
  }

  println(stringToIntConverter("3") + 4)

  val adder: ((Int, Int) => Int) = new Function2[Int, Int, Int] {
    override def apply(a: Int, b: Int): Int = a + b
  }

  // 1.
  def concatenator: (String, String) => String = (a: String, b: String) => a + b
  println(concatenator("Hello ", "Scala"))

  // 3. Function1[Int, Function1[Int, Int]]
  val specialFunction: Function1[Int, Function1[Int, Int]] = new Function1[Int, Function1[Int, Int]] {
    override def apply(x: Int): Function1[Int, Int] = new Function[Int, Int] {
      override def apply(y: Int): Int = x + y
    }
  }

  val specialFunctionSS: Function1[Int, Function1[Int, Int]] = (x: Int) => new Function[Int, Int] {
    override def apply(y: Int): Int = x + y
  } // Both solutions are the same

  val adder3 = specialFunction(3)
  println(adder3(3))
  println(specialFunction(3)(4))
  println(specialFunctionSS(3)(4))

}

// Function types Function2[A, B, R] === (A, B) => R
// ALL SCALA FUNCTIONS ARE OBJECTS (Instances of classes derived from Function1, Function2, etc.)
// This is the byproduct of building a functional programming language in JVM, which is designed to be Object Oriented

class Action {
  def execute(element: Int): String = ???
}

trait MyFunction[A, B] {
  def apply(element: A): B
}

/*
  1. A function which takes 2 strings and concatenates them
  2. Transform the MyPredicate and MyTransformer into function types
  3. Define a function which takes an int and returns another function which takes an int and returns an int
    - What's the type of this function
    - How to do it
 */
