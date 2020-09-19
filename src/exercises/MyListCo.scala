package exercises

  abstract class MyListCo[+A] {

    /*
      head = first element of the list
      tail - remainder of the list
      isEmpty = is this list empty
      add(int) => new list with this element added
      toString => a string representation of the list
    */

    def head: A
    def tail: MyListCo[A]
    def isEmpty: Boolean
    def add[B >: A](element: B): MyListCo[B]
    def printElements: String
    override def toString: String = "["+ printElements +"]"

    def map[B](transformer: MyTransformer[A,B]): MyListCo[B]
    def flatMap[B](transformer: MyTransformer[A,MyListCo[B]]): MyListCo[B]
    def filter(predicate: MyPredicate[A]): MyListCo[A]

    // Concatenation
    def ++[B >: A](list: MyListCo[B]): MyListCo[B]
  }

  object Empty extends MyListCo[Nothing] {
    def head: Nothing = throw new NoSuchElementException
    def tail: MyListCo[Nothing] = throw new NoSuchElementException
    def isEmpty: Boolean = true
    def add[B >: Nothing](element: B): MyListCo[B] = new Cons(element, Empty)
    override def printElements: String = ""

    def map[B](transformer: MyTransformer[Nothing,B]): MyListCo[B] = Empty
    def flatMap[B](transformer: MyTransformer[Nothing,MyListCo[B]]): MyListCo[B] = Empty
    def filter(predicate: MyPredicate[Nothing]): MyListCo[Nothing] = Empty

    def ++[B >: Nothing](list: MyListCo[B]): MyListCo[B] = list
  }

  class Cons[+A](h: A, t: MyListCo[A]) extends MyListCo[A] {
    def head: A = h
    def tail: MyListCo[A] = t
    def isEmpty: Boolean = false
    def add[B >: A](element: B): MyListCo[B] = new Cons(element, this)

    def printElements: String =
      if (t.isEmpty) "" + h
      else h + " " + t.printElements

    /*
      [1,2,3].filter(n % 2 == 0) =
      [2, 3].filter(n % 2 == 0) =
      = new Cons(2, [3].filter(n % 2 == 0))
      = new Cons(2, Empty.filter(n % 2 == 0))
      = new Cons(2, Empty)
     */

    def filter(predicate: MyPredicate[A]): MyListCo[A] =
      if (predicate.test(h)) new Cons(h, t.filter(predicate))
      else t.filter(predicate)

    /*
      [1,2,3].map(n * 2)
      = new Cons(2, [2,3].map(2 * 2))
      = new Cons(2, new Cons(4, [3].map(n * 2)))
      = new Cons(2, new Cons(4, new Cons(6, Empty.map(n * 2))))
      = new Cons(2, new Cons(4, new Cons(6, Empty))))
     */

    def map[B](transformer: MyTransformer[A,B]): MyListCo[B] =
      new Cons(transformer.transform(h), t.map(transformer))

    /*
      [1,2] ++ [3,4,5]
      = new Cons(1, [2] ++ [3,4,5])
      = new Cons(1, new Cons(2, Empty ++ [3, 4, 5]))
      = new Cons(1, new Cons(2, [3,4,5]))
      = new Cons(1, new Cons(2, new Cons(3, new Cons(4, new Cons(5)))))
     */

    def ++[B >: A](list: MyListCo[B]): MyListCo[B] = new Cons(h, t ++ list)
 
    def flatMap[B](transformer: MyTransformer[A, MyListCo[B]]): MyListCo[B] =
      transformer.transform(h) ++ t.flatMap(transformer)
  }

  trait MyPredicate[-T] {
    def test(element: T): Boolean
  }

  trait MyTransformer[-A, B] {
    def transform(element: A): B
  }

  object ListTest extends App {
    val listOfIntegers: MyListCo[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
    val listOfStrings: MyListCo[String] = new Cons("Hello", new Cons("My", new Cons("Boy", Empty)))
  }


