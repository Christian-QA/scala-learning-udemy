package lectures.part2oop

object Inheritance extends App {

  //Udemy: Lecture 12 - Inheritance
  // Single Class Inheritance
  class Animal {
    val creatureType = "Wild"
    def eat = println("nomnomnom")
  }

  class Cat extends Animal {
    def crunch = {
      eat
      println("Crunch crunch")
    }
  }

  val cat = new Cat
  cat.eat
  cat.crunch

  // Constructors
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }
  class Adult(name: String, age: Int, idCard: String) extends Person(name)

  // Overriding
  class Dog(override val creatureType: String) extends Animal {
    override def eat = {
      // Super
      super.eat
      println("INHALE!")
    }

    //override val creatureType: String = "Domesticated"
  }
  val dog = new Dog("Domesticated")
  dog.eat
  println(dog.creatureType)

  // Type Substitution (broad: polymorphism)
  val unknownAnimal: Animal = new Dog("K9")
  unknownAnimal.eat

  // Overriding (multiple methods with the same name but different values) vs Overloading (multiple methods with the same name but different signature)

  /* Preventing Overrides methods:
    1. Use final on member (i.e. final before 'eat' in the Animal class)
    2. Use final before class (prevents extension of the class i.e. cats and dogs as shown above)
    3. Seal the class (Can extend class in THIS FILE, but prevents it in OTHER FILES, in this case, only cats and dogs are the only possible extensions Animal can have)
   */


}
