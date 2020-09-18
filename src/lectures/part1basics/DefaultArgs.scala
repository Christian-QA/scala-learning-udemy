package lectures.part1basics

object DefaultArgs extends App {

  ///Udemy: Lecture 7 - Default and Named Arguments
  def trFactorial(n: Int, accumulator: Int = 1): Int =
    if (n <= 1) accumulator
    else trFactorial(n-1, n*accumulator)

  val factorial10 = trFactorial(10)

  def savePicture(format: String = "jpg", width: Int, height: Int): Unit = println("saving picture")

  /* The default value of the format parameter is pointless as it'll always assume the first parameter set when
  the function is called is format on account of it being before the parameters without default values.
  There are two solutions to this:
   */

  // 1. Pass in every leading argument
  savePicture("bmp", 800, 600)

  // 2. Rearrange the order
  def savePictureRearranged(width: Int, height: Int, format: String = "jpg"): Unit = println("saving picture")
  savePictureRearranged(800, 600)

  // 3. Name the arguments
  savePicture(height = 600, width = 800) // Note, the order doesn't matter in this case, making it the most flexible

}
