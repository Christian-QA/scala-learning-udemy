package lectures.part2oop

object AbstractDataTypes extends App {

  // Abstract
  abstract class Animal {
    val creatureType: String
    def eat: Unit
  }

  // val animal = new Animal // This won't work because creatureType and eat are yet to be implemented

  class Dog extends Animal { // Must be abstract or use creatureType and eat
    override val creatureType: String = "Doggo"
    override def eat = println("crunch crunch")
  }

  // Traits
  trait Carnivore {
    def eat(animal: Animal): Unit
    val preferredMeal: String = "Sloppy Kebab"
  }

  trait ColdBlooded

  class Crocodile extends Animal with Carnivore with ColdBlooded {
    val creatureType: String = "Crocco" // Doesn't need override modifier unless the original val from animal has a default value
    def eat: Unit = println("WompWompWomp")
    def eat(animal: Animal): Unit = println(s"I'm big $creatureType and I eat ${animal.creatureType}")
  }

  val dog = new Dog
  val crocodile = new Crocodile
  crocodile.eat(dog)

  /* Traits vs Abstract Classes
  1. Traits do not have constructor parameters
  2. You can only extend one class, but can have multiple traits inherited by the same class as shown with the Crocodile class above
  3. traits = behaviour, abstract class = thing (Animal describes animals, traits describes what they do)
  */
}
