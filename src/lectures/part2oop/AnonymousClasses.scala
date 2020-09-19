package lectures.part2oop

object AnonymousClasses extends App{

  //Udemy: Lecture 14 - Anonymous Classes
  abstract class Animal {
    def eat: Unit
  }



  // Anonymous Class
  val funnyAnimal: Animal = new Animal {
    override def eat: Unit = println("AHAWHAHAHAHAHAHA")
  }
  /*
    Equivalent with

    class AnonymousClasses$$anon$1 extends Animal {
      override def eat: Unit = println("AHAWHAHAHAHAHAHA")
    }
   */

  println(funnyAnimal.getClass)

  class Person(name: String) {
    def sayHit: Unit = println(s"Hi, my name is $name, how can I help?")
  }

  val jim = new Person("Jim") {
    override def sayHit: Unit = println(s"Hi, my name is Jim, how can I be of service")
  }

  /*
  1. Generic trait MyPredicate[-T] with a little method test(t) => Boolean
  2. Generic trait MyTransformer[-A, B] with a method transform(A) => B
  3. MyList:
    - map(transformer) => MyList
    - filter(predicate) => MyList
    - flatMap(transformer from A to MyList[B]) => MyList[B]

    class EvenPredicate extends MyPredicate[Int]
    class StringToIntTransformer extends MyTransformer[String, Int]

    [1, 2, 3].map(n * 2) = [2, 4, 6]
    [1, 2, 3, 4].filter(n % 2) = [2, 4]
    [1, 2, 3].flatmap(n => [n, n+1] => [1, 2, 2, 3, 3, 4]
  */

}
