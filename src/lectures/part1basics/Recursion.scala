package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {

  def factorial(n: Int): Int =
    if (n <= 1) 1
    else {
      println("Computing factorial of " + n + " - I first need factorial of " + (n-1))
      val result = n * factorial(n-1)
      println("Computed factorial of " + n)
      result
    }
  println(factorial(9)) // Setting the recursive depth too high will result in a stack overflow error (around 535)

  // The solution to this...

  def anotherFactorial(n: Int): BigInt = {
    def factorialHelper(x: Int, accumulator: BigInt): BigInt =
      if (x <= 1) accumulator
      else factorialHelper(x - 1, x * accumulator)

    factorialHelper(n, 1)
  }

  /*
    anotherFactorial(10) = factorialHelper(10, 1)
    = factorialHelper(9, 10 * 1)
    = factorialHelper(8, 9 * 10 * 1)
    ...
    = factorialHelper(2, 3 * 4 * ... * 10 * 1)
    = factorialHelper(1, 1 * 2 * ... * 10 * 1)
    = 1 * 2 * ... * 10
   */

  println(anotherFactorial(5000))

  // The reason this works and the first one doesn't is because having factorialHelper as its own expression means
  // the application doesn't try to preserve each recursion, but rather replaces it. This means the size of
  // the stack is limited to one value.
  // This is called Tail Recursion: use the recursive call as the LAST expression, which can be checked with @tailrec

  // The Takeaway, WHEN YOU NEED LOOPS, USE TAIL RECURSION

  /// Exercises
  // 1. Concatenate a string n times
  @tailrec
  def greetingFunction(name: String, n: Int, accumulator: String): String =
    if (n <= 0) accumulator
    else greetingFunction(name, n-1, name + accumulator)
  println(greetingFunction("John", 5, ""))

  // 2. isPrime function tail recursive
  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeUntil(t: Int, accumulator: Boolean): Boolean = {
      if (!accumulator) false
      else if (t <= 1) true
      else isPrimeUntil(t-1, n % t != 0 && accumulator)
    }
    isPrimeUntil(n / 2, true)
  }
  println(isPrime(2003))

  // 3. Fibonacci function, tail recursive
  def fibonacciFunction(n: Int): Int = {
    def fibonacciHelper(i: Int, accumulatorOne: Int, accumulatorTwo: Int): Int =
    if (i >= n) accumulatorTwo
    else fibonacciHelper(i + 1, accumulatorOne + accumulatorTwo, accumulatorOne)

  if (n <= 2) 1
  else fibonacciHelper(2, 1, 1)
  }

  println(fibonacciFunction(8))
}
