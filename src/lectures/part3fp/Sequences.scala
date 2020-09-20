package lectures.part3fp

import scala.util.Random

object Sequences extends App {

  //Udemy: Lecture - Sequences

  /// Sequences
  // A very general interface for datastructures that have a well defined order and can be indexed
  val aSequence = Seq(1,5,3,4)
  println(aSequence)
  println(aSequence.reverse)
  println(aSequence(2))
  println(aSequence ++ Seq(11,6,7))
  println(aSequence.sorted)

  /// Ranges
  val aRange: Seq[Int] = 1 to 10 // until to exclude 10
  aRange.foreach(println)

  (1 to 10).foreach(x => println("Hello"))

  /// Lists
  val aList = List(1,2,3)
  val prepended = 42 +: aList :+ 89
  println(prepended)

  val apples5 = List.fill(5)("apple")
  println(apples5)
  println(aList.mkString("-|-"))

  // Arrays
  val numbers = Array(1,2,3,4)
  val treeElements = Array.ofDim[Int](3)
  println(treeElements) // Returns hashcode
  treeElements.foreach(println) // Returns three 0s

  // Mutation
  numbers(2) = 0 // Syntactic sugar for numbers.update(2, 0)
  println(numbers.mkString(" "))

  // Arrays and Seq
  val numbersSeq: Seq[Int] = numbers // Implicit Conversion
  println(numbersSeq)

  /// Vectors
  // The default implementation for immutable sequences
  val vector: Vector[Int] = Vector(1,2,3)
  println(vector)

  // Vectors vs Lists
  val maxRuns = 1000
  val maxCapacity = 1000000
  def getWriteTime(collection: Seq[Int]): Double = {
    val r = new Random
    val times = for {
      it <- 1 to maxRuns
    } yield {
      val currentTime = System.nanoTime()
      collection.updated(r.nextInt(maxCapacity), r.nextInt())
      System.nanoTime() - currentTime
    }
    times.sum * 1.0 / maxRuns
  }

  val numbersList = (1 to maxCapacity).toList
  val numbersVector = (1 to maxCapacity).toVector

  // Keeps reference to tail
  // Updating an element in the middle takes a long time
  // Operation takes 1.19724549E7 nanoseconds (11 milliseconds)
  println(getWriteTime(numbersList))

  // Depth of the tree is small
  // Needs to replace an entire 32-element chunk
  // Operation takes 5016.4 nanoseconds (5 microseconds)
  println(getWriteTime(numbersVector))
}
