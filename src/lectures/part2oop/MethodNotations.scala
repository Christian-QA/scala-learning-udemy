package lectures.part2oop

object MethodNotations extends App {

  //Udemy: Lecture 10 - Method Notations
  class Person(val name: String, favouriteMovie: String, val age: Int = 0) {
    def likes(movie: String): Boolean = movie == favouriteMovie
    def hangOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def +(person: Person, alias: String): String = s"${this.name}${alias} is hanging out with ${person.name}"
    def unary_! : String = s"${name}, dude..." //Note: needs space between unary_! and : to make clear that : isn't part of the method's name
    def unary_+ : Person = new Person(name, favouriteMovie, age + 1)
    def isAlive: Boolean = true
    def apply(): String = s"Hi, my name is $name and I like $favouriteMovie"
    def apply(n: Int): String = s"Hi, my name is $name and I watched $favouriteMovie $n times"

    def learns(thing: String) = s"$name is learning $thing"
    def learnsScala = this learns "Scala"
  }

  val rafael = new Person("Rafael", "Fateful Findings")
  println(rafael.likes("Fateful Findings"))
  println(rafael likes "Fateful Findings") // This and above are the same
  // Infix notation = operator notation, works for any method with a single parameter (Syntactic Sugar, closer to human language)

  // "operators" in Scala
  val hunter = new Person("Hunter", "Dora the Explorer")
  println(rafael hangOutWith hunter)
  println(rafael + hunter)
  println(rafael.+(hunter)) // This and above are the same

  println(1 + 2)
  println(1.+(2))

  // ALL OPERATORS ARE METHODS IN SCALA.
  // Akka actors have ! ?

  // Prefix Notation
  val x = -1
  val y = 1.unary_- // This and above are the same.
  // unary_ prefix only works with a few operators: - + ~ !

  println(!rafael)
  print(rafael.unary_!) // This and above are the same

  // Postfix Notation
  println(rafael.isAlive)
  println(rafael isAlive) // This and above are the same
  // The syntactic sugar approach to Postfix notations isn't recommended as it may introduce ambiguity to a human reader
  // There's virtually no additional effort between the two approaches

  // Apply
  println(rafael.apply())
  println(rafael()) // This and above are the same
  // Using rafael() will prompt the compiler to look for an apply() method in the class.
  // Using anything other than apply() will not work.



    ///1. Overload the + operator
    //mary + "the rockstar" => new person "Mary (the rockstar)"
    println(rafael +(hunter, " the Rockstar"))


    ///2. Add an age to the Person class
    //Add a unary_+ operator => new person with the age + 1
    //+mary => mary with the age incrementer
    println((+rafael).age)

    ///3. Add a "learns" method in the Person class => "Mary learns Scala"
    //Add a learnsScala method, calls learns method with "Scala".
    //Use is in postfix notation
    print(rafael learnsScala)

    ///4. Overload the apply method
    //mary.apply(2) => "Mary watched Inception 2 times"
    print(rafael(2))

}
// class Person needs to be inside the object so it doesn't conflict with the class person from OOPBasics
