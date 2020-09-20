package lectures.part3fp

object AnonymousFunctions extends App {

  //Udemy: Lecture - Anonymous Functions

  // Anonymous function (Lambda)
  val doubler: Int => Int = (x: Int) => x * 2

  // Multiple params in a lambda
  val adder: (Int, Int) => Int = (a: Int, b: Int) => a + b

  // No params in a lambda
  val justDoSomething: () => Int = () => 3

  println(justDoSomething) // Hashcode of the function itself
  println(justDoSomething()) // 3
  /// Lambdas must be used with parenthesis

  // Curly braces with lambdas
  val stringToInt = { (str: String) =>
    str.toInt
  }

  // MORE SYNTACTIC SUGAR
  val niceIncrememter: Int => Int = _ + 1 // Equivalent to x => x + 1
  val niceAdder: (Int, Int) => Int = _ + _ // Equivalent to (a, b) => a + b
  // The _ is extremely contextual, and the compiler requires the type specified in order to be sure what they are


  /*
    Exercise
    Rewire the "special" adder as an anonymous function
   */

  val superAdd = (x: Int) => (y: Int) => x + y
  println(superAdd(3)(4))

}
