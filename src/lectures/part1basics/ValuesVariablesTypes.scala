package lectures.part1basics

object ValuesVariablesTypes extends App {

  ///Udemy
  //Types and Val
  //Vals are immutable. Functional programming involves working less with variables
  val x: Int = 453; // Type declared by me
  println(x);

  val y = 221; // Type inferred by the compiler
  println(y);

  val aString: String = "Hello";
  val anotherString = "Goodbye"
  println(aString);
  println(anotherString);

  val aBoolean: Boolean = true;
  println(aBoolean);

  val aChar: Char = 'a';
  println(aChar);

  val aShort: Short = 9124;
  println(aShort);

  val aLong: Long = 456534563456L;
  println(aLong);

  val aFloat: Float = 2.0f;
  println(aFloat);

  val aDouble: Double = 5.542;
  println(aDouble);

  //Variables
  var aVariable: Int = 53;
  println(aVariable);
  aVariable = 68 // Side Effect
  println(aVariable);
  // Vars are mutable, only use when absolutely necessary to prevent bugs

}
