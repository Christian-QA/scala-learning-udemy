package lectures.part2oop

object Generics extends App {

  //Udemy: Lecture 13 - Generics
  class MyList[A] {
    // use the type A
    def add[B >: A](element: B): MyList[B] = ???
    /*
    A = Cat
    B = Animal (as Dog is added to the list, meaning it's no longer strictly a list of cat)
     */
  }

  class MyMap[key, Value]
  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]

  // Generic Methods
  object MyList {
    def empty[A]: MyList[A] = ???
  }
  val emptyListOfIntegers = MyList.empty[Int]

  // Variance problem
  // Does the following extend list of Animal to list of Cat
  class Animal
  class Cat extends Animal
  class Dog extends Animal


  /// 1. Yes, animalList.add(new Dog) ??? HARD QUESTION. It pollutes the list of Cat
  // List[Cat] extends List[Animal] = Covariance
  class CovariantList[+A]
  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  // Adding a list of Dogs to the list of Cats will make it a list of generic animals

  // 2. No, INVARIANCE
  class InvariantList[A]
  val invariantAnimalList: InvariantList[Animal] = new InvariantList[Animal]


  // 3. NO! Contravariance
  class ContravariantList[-A]
  val contravariantList: ContravariantList[Cat] = new ContravariantList[Animal]

  // 3.1 Use a trainer, can be applied to any animal from Cat to Dragon
  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]

  // Bounded Types
  class Cage[A <: Animal] (animal: A) // Will only accept subtypes of Animal
  val cage = new Cage(new Dog)

  //class Car
  //val newCage = new Cage(new Car)

}
