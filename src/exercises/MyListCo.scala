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
  }

  object Empty extends MyListCo[Nothing] {
    def head: Nothing = throw new NoSuchElementException
    def tail: MyListCo[Nothing] = throw new NoSuchElementException
    def isEmpty: Boolean = true
    def add[B >: Nothing](element: B): MyListCo[B] = new Cons(element, Empty)
    override def printElements: String = ""
  }

  class Cons[+A](h: A, t: MyListCo[A]) extends MyListCo[A] {
    def head: A = h
    def tail: MyListCo[A] = t
    def isEmpty: Boolean = false
    def add[B >: A](element: B): MyListCo[B] = new Cons(element, this)

    def printElements: String =
      if (t.isEmpty) "" + h
      else h + " " + t.printElements
  }
  object ListTest extends App {
    val listOfIntegers: MyListCo[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
    val listOfStrings: MyListCo[String] = new Cons("Hello", new Cons("My", new Cons("Boy", Empty)))
  }


