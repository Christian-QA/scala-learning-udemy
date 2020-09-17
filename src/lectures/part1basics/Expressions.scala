package lectures.part1basics

object Expressions extends App {

  //Note: Omitting Semi-Colons from now on to play to Scala's strengths

  val x = 1 + 2 // Expression
  println(x)

  println(2 + 3 * 4)
  // More info on Scala-compatible operators can be found here: https://www.journaldev.com/7589/scala-operator-arithmetic-relational-logical-bitwise-assignment

  println(1 == x)

  println(!(1 == x) && !(2 == x) || !(4 == x))

  var aVariable = 2
  aVariable += 3 // Example of a side effect, as well as -= *= /=, as such only works with var
  println(aVariable)

  /// Instructions (Execution, the act of doing, think Java) vs Expressions (Evaluation, Value and Types, think Scala)
  // If expression
  val aCondition = true
  val aConditionedValue = if (aCondition ) 5 else 3

  println (aCondition)
  println (aConditionedValue)
  println (if (aCondition ) 6 else 9)

  /// Loops
  // Loops exist with Scala though are strongly dissuaded as they solely produce side effects,
  // something which are intentionally minimised in Scala applications.
  // The below is an example of a loop for the sake of knowing, though I'll likely NEVER need.

  var i = 0 // Naturally, it needs to be var on account of it being inherently mutable
  while (i < 10) {
    println(i)
    i += 1
  }

  // ^ 'I'll likely NEVER need' ^
  // It has no place in Functional Programming, it's a product of Imperative Programming (i.e. Java

  // EVERYTHING in Scala is an Expression (barring the obvious, i.e. definitions like val, class or package)

  val aWeirdValue = (aVariable = 3) // Unit === void, doesn't return anything meaningful
  println(aWeirdValue)

  // Side Effects are reminiscent of Imperative Programming, including: println(), whiles and reassigning
  // Side Effects return units.

  /// Code Blocks
  // The value of a code block is the value of its last expression
  // Code Blocks are scope-sensitive, meaning the other expressions in the code block are inaccessible outside the code block
  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if (z > 2) "hello" else "goodbye" //This is the returned expression, the 'return' keyword is unnecessary
  }
  println(aCodeBlock)

  // 1. difference between "hello world" vs println("hello world")?
  "hello world" // Doesn't print to console. It's an expression with type String, not an instruction with type Unit

  // 2.
  val someValue = {
    2 < 3
  }
  println(someValue) // Returns true, it's treated as a boolean if statement, a relational operation

  // 3.
  val someOtherValue = {
    if(someValue) 239 else 986
    42
  }
  println(someOtherValue) // Returns 42, everything is an expression in Scala, and 42 is at the end of the code block.
  // This makes 42 the last expression, and makes the previous if statement pointless

}
