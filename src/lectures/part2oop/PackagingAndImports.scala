package lectures.part2oop

import playground.{Cinderella => Princess, PrinceCharming}
/// Import aliases are useful for preventing name conflicts i.e.
// import java.util.Date
// import java.sql.Date
/// The other solution is to use full names when calling i.e. val time = new java.sql.Date

object PackagingAndImports extends App {

  //Udemy: Lecture - Packaging and Imports

  // Packaging members are accessible by their simple name
  val write = new Writer("Danny", "Rockstar", 2013)

  // Import the package
  val princess = new Princess
  val princess2 = new playground.Cinderella // Both are the same

  // Packages are part of a hierarchy
  // Matching folder structure, the same with Java

  // Package object
  sayHello
  println(SPEED_OF_LIGHT)

  // Imports
  val prince = new PrinceCharming

  // Default Imports
  // These are imports which are put into projects by default, including:
  // 1. java.lang - String, Object, Exception, etc.
  // 2. scala - Int, Nothing, Function, etc.
  // 3. scala.Predef - println, ???, etc.


}
