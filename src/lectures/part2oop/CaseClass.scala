package lectures.part2oop

object CaseClass extends App {

  /*
    equals, hashCode, toString
   */

  case class Person(name: String, age: Int)

  // 1. class parameters are fields
  val jim = new Person("Jim", 34)
  println(jim.name)

  // 2. Sensible toString
  // toString in this case isn't needed due to syntactic sugar
  print(jim.toString) // not having the 'case' before 'class' would result in trying to convert the hashcode to a String

  // 3. equals and hashcode implemented OOTB
  val jim2 = new Person("Jim", 34)
  println(jim == jim2) // Returns true as long as it's a case class, otherwise it would return false

  // 4. CCs have handy copy method
  val jim3 = jim.copy(age = 45)
  println(jim3)

  // 5. CCs have companion objects
  val thePerson = Person
  val mary = Person("Mary", 23)

  // 6. CCs are serializable
  // Akka

  // 7. CCs have extractor patterns = CCs can be used in PATTERN MATCHING

  case object UnitedKingdom {
    def name: String = "Had a Monarch and Prime Minister"
  }

}
