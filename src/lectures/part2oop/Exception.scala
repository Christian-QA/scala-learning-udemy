package lectures.part2oop

object Exception extends App {

  //Udemy: Lecture - Exceptions
  val x: String = null
  // println(x.length)
  // this ^^ will crash with NullPointerException

  // 1. Throwing and Catching Exceptions

  /// val aWeirdValue: String = throw new NullPointerException
  // throwable classes extend the Throwable class
  // Exception and Error are the major Throwable subtypes

  // 2. How to Catch Exceptions
  def getInt(withExceptions: Boolean): Int =
    if (withExceptions) throw new RuntimeException("Broke, dude")
    else 42

  val potentialFail = try {
    // Code that might fail
    getInt(false)
  } catch {
    case e: RuntimeException => println("Caught a Runtime Exception")
  } finally {
    // Code that will get executed no matter what
    // Optional
    // Does not influence the return type of this expression
    // Use finally only for side effects
    println("FINALLY")
  }
  println(potentialFail)

  /// 3. How to Define Your Own Exceptions
  //class MyException extends Exception
  //val exception = new MyException
  //throw exception

  /*
    1. Crash your program with an OutOfMemoryError
    2. Crash with StackOverflowError
    3. Pocket Calculator
      - add(x,y)
      - subtract(x,y)
      - multiply(x,y)
      - divide(x,y)

      Throw
        - OverflowException if add(x,y) exceeds Int.MAX_VALUE
        - UnderflowException if subtract(x,y) exceeds Int.MIN_VALUE
        - MathCalculatorException for division by 0
   */

  /// 1. OutOfMemoryError
  //val array = Array.ofDim(Int.MaxValue)

  /// 2. StackOverflowError
  // def infinite: Int = 1 + infinite
  // val noLimit = infinite

  /// 3. Pocket Calculator
  class OverflowException extends RuntimeException
  class UnderflowException extends RuntimeException
  class MathCalulationException extends RuntimeException("Cannot divide by zero")

  object PocketCalculator {
    def add(x: Int, y: Int) = {
      val result = x + y
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result > 0) throw new UnderflowException
      else result
    }


    def subtract(x: Int, y: Int): Unit = {
      val result = x - y
      if (x > 0 && y < 0 && result < 0) throw new OverflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def multiply(x: Int, y: Int): Unit = {
      val result = x * y
      if (x > 0 && y > 0 && result < 0) throw new OverflowException
      else if (x < 0 && y < 0 && result < 0) throw new OverflowException
      else if (x > 0 && y < 0 && result > 0) throw new UnderflowException
      else if (x < 0 && y > 0 && result > 0) throw new UnderflowException
      else result
    }

    def divide(x: Int, y: Int) = {
      if (y == 0) throw new MathCalulationException
      else x / y
    }
  }

  println(PocketCalculator.add(Int.MaxValue, 10))
  println(PocketCalculator.subtract(11, 10))
  println(PocketCalculator.multiply(11, 10))
  println(PocketCalculator.divide(11, 10))
  println(PocketCalculator.subtract(11, 0))
}
