package lectures.part1basics

object CallByNameOrValue extends App {

  def calledByValue(x: Long): Unit = {
    println("By value: " + x)
    println("By value: " + x)
  }

  def calledByName(x: => Long): Unit = {
    println("By name: " + x)
    println("By name: " + x)
  }

  calledByValue(System.nanoTime())
  calledByName(System.nanoTime())

  def infinite(): Int = 1 + infinite()
  def printFirst(x: Int, y: => Int) = println(x)

  /// printFirst(infinite(), 34) Causes Stack Overflow Error as the function's run infinite times
  printFirst(34, infinite()) // Doesn't cause Error as y isn't evaluated, it would need to be used
}
