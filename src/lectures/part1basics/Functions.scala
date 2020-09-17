package lectures.part1basics

object Functions extends App {

  def aFunction(a: String, b: Int): String =
    a + " " + b

  def aFunctionBlock(a: String, b: Int): String = {
    a + " " + b
  }

    println(aFunction("Hey", 5) == aFunctionBlock("Hey", 5))
  // Both of the above equal the same value

  def aFunctionBlockNoReturn(a: String, b: Int) = {
    a + " " + b
  }

  println(aFunction("Hey", 5) == aFunctionBlock("Hey", 5) == aFunctionBlockNoReturn("Hey", 5))
  // However, having no return type makes it different?

  def aParameterlessFunction(): Int = 42
  println(aParameterlessFunction())
  println(aParameterlessFunction)

  def aRepeatedFunction(aString: String, n: Int): String = { // Recursive functions NEED a return type
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n-1)
  }
  println(aRepeatedFunction("hello ", 3))
  // WHEN YOU NEED LOOPS, USE RECURSION

  def aFunctionWithSideEffects(aString: String): Unit = println(aString)

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int) = a + b

    aSmallerFunction(n, n-1)
  }
  println(aBigFunction(4))

  /// Exercises
  // 1. A greeting function (name, age) => "Hi, my name is $name and I am $age years old"
  def greetingFunction(name: String, age: Int): String =
    "Hi, my name is " + name + " and I am " + age + " years old"
  println(greetingFunction("John", 98))

  // 2. Factorial function => 1 * 2 * 3 * .. * n
  def factorialFunction(n: Int): Int =
    if (n <= 0) 1
    else n * factorialFunction(n-1)
  println(factorialFunction(4))

  // 3. Fibonacci function => f(1) = 1, f(2) = 1, f(n) = f(n - 1) + f(n - 2)
  def fibonacciFunction(n: Int): Int =
    if(n <= 2) 1
    else fibonacciFunction(n-1) + fibonacciFunction(n-2)

  println(fibonacciFunction(5))

  // 4. Tests if a number is prime
  def isPrime(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean =
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t-1)

    isPrimeUntil(n / 2)
  }
  println(isPrime(37))
  println(isPrime(2003))
  println(isPrime(37*17))

}
