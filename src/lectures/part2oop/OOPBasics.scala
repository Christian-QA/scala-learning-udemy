package lectures.part2oop

object OOPBasics extends App {

  //Udemy: Lecture 9 - OOP Basics
  val person = new Person("Chris", 24)
  println(person.name)

  val personTwo = new PersonTwo("Chris", 42)
  println(personTwo.x) // Will print off 4 as it's within the class as a side effect, then 2 as it's the value of x as requested

  val personThree = new PersonThree("Stan")
  println(personThree.greet("Janice"))
  println(personThree.greet())


  /// Exercises
  //1.
  val writer = new Writer("Neil", "Breen", 2003)
  val imposter = new Writer("Neil", "Breen", 2003)
  println(writer.fullName)

  val novel = new Novel("Fateful Findings", 2007, writer)
  println(novel.authorAge)
  println(novel.isWrittenBy(writer))
  println(novel.isWrittenBy(imposter))

  //2.
  val counter = new Counter()
  counter.incrementCounter.print
  counter.incrementCounter.incrementCounter.incrementCounter.print
  counter.decrementCounter.print

  counter.incrementCounter(10).print


}

class Person(val name: String, age: Int) // Constructor in Scala
// Class Parameters are NOT FIELDS (i.e. person.age would not work, but person.name will as it's defined as a value)

class PersonTwo(name: String, val age: Int) {
  // Body
  val x = 2
  println(1 + 3)
}

class PersonThree(name: String) {
  // Method
  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")

  // Overloading
  def greet(): Unit = println(s"Hi, I am ${this.name}") // 'this.' has no purpose here because there's no parameter to overload the value
  // This is overloading because the function uses the same name but a different signature. Having the same signature would cause an error

  // Multiple Constructors
  //def this(name: String) = this(name)
  //def this() = this("Rafael")
}

/// Exercises
  /*
  1. Novel and a Writer
  Writer: forename, surname, year of birth
  - fullName

  Novel: name, year of release, author
  - authorAge
  - isWrittenBy (author)
  - copy (new year of release) = new instance of Novel
*/

class Writer(forename: String, surname: String, val YoB: Int) {
  def fullName: String = forename + " " + surname
}

class Novel(name: String, YoR: Int, writer: Writer) {
  def authorAge = YoR - writer.YoB
  def isWrittenBy(writer: Writer) = writer == this.writer
  def copy(newYear: Int): Novel = new Novel(name, newYear, writer)

}

  /*
  2.
    Counter Class
    - Receives an int value
    - Method current count
    - Method to increment/decrement => new Counter
    - Overload inc/dec to receive an amount
   */

class Counter(val count: Int = 0) {
  def incrementCounter = {
    println("Incrementing value: " + count)
    new Counter(count + 1) // Requires a new Counter to remain immutable, which in turn means a more stable application.
  }
  def decrementCounter = {
    println("Decrementing value: " + count)
    new Counter(count - 1) // Immutability is a central concept of functional programming, relying on new over modified instances.
  }

  def incrementCounter(n: Int): Counter = {
    if (n <= 0) this
    else incrementCounter.incrementCounter(n-1)
  }
  def decrementCounter(n: Int): Counter = {
    if (n <= 0) this
    else decrementCounter.decrementCounter(n-1)
  }

  def print = println(count)
}




