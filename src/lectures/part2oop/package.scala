package lectures

package object part2oop { // Only one package object per package, sharing the package name
  // This makes all code below visible throughout the entire package

  def sayHello: Unit = println("Hello, Scala")
  val SPEED_OF_LIGHT =  299792458

}
