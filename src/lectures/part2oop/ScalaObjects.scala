package lectures.part2oop

object ScalaObjects {
  // Scala does not have class-level functionality ("static")

  //Udemy: Lecture 11 - Scala Objects
  object Person { // Type + its only instance
    // "static"/"class"-level functionality
    val N_EYES = 2
    def canFly: Boolean = false

    // Factory Method
    def apply(mother: Person, father: Person): Person = new Person("Bobby")
  }
  class Person(val name: String) {
    // Instance-level functionality
  }
  // ^ Companions ^
  // All code will reside in an object or class.
  // Class is used to create an instance from its inherited properties
  // Object is used to access a code from a singleton instance, with no unique properties between them when called multiple times

  def main(args: Array[String]): Unit = {
    println(Person.N_EYES)
    println(Person.canFly)

    // Scala object = SINGLETON INSTANCE
    val john = Person
    val jan = Person
    println(john == jan) // True because they point to the same instance, the object Person
    println(john.N_EYES) // To further clarify, this uses the object 'Person' as demonstrated by accessing N_EYES

    val john2 = new Person("John")
    val jan2 = new Person("Jan")
    println(john2 == jan2) // False because each have a new instance created for them
    // println(john2.N_EYES) This uses the class 'Person', as demonstrated by an error thrown when trying to access N_EYES, which isn't in the class instance

    val bobbie = Person(jan2, john2)

    // Scala Applications = Scala object with
    // def main(args: Array[String]): Unit
    // This is important as Scala applications use JVM and needs to have a method it understands
  }

}
