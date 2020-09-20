package lectures.part3fp

import lectures.part3fp.Options.{connection, host}

import scala.util.{Failure, Random, Success, Try}

object HandlingFailure extends App {

  //Udemy: Lecture - Handling Failure

  // Create success and failure
  val aSuccess = Success(3)
  val aFailure = Failure(new RuntimeException("Big Fail"))

  println(aSuccess)
  println(aFailure)

  def unsafeMethod(): String = throw new RuntimeException("Wat?")

  // Try objects via the apply method
  val potentialFailure = Try(unsafeMethod())
  println(potentialFailure)

  // Syntactic Sugar
  val anotherPotentialFailure = Try {
    // code that might throw
  }

  // Utilities
  println(potentialFailure.isSuccess)

  //orElse
  def backupMethod(): String = "A valid result"
  val fallbackTry = Try(unsafeMethod()).orElse(Try(backupMethod()))
  println(fallbackTry)

  // IF you design the API
  def betterUnsafeMethod(): Try[String] = Failure(new RuntimeException)
  def betterBackupMethod(): Try[String] = Success("A valid result")
  val betterFallback = betterUnsafeMethod() orElse betterBackupMethod()

  // map, flatMap, filter
  println(aSuccess.map(_ * 2))
  println(aSuccess.flatMap(x => Success(x * 10)))
  println(aSuccess.filter(_ > 10))
  // => for-comprehensions

  /*
    Exercise
   */

  val hostname = "localhost"
  val port = "8080"
  def renderHTML(page: String) = println(page)

  class Connection {
    def get(url: String): String = {
      val random = new Random(System.nanoTime())
      if (random.nextBoolean()) "<html>...</html>"
      else throw new RuntimeException("Connection interrupted")
    }

    def getSafe(url: String): Try[String] = Try(get(url))
  }

  object HttpService {
    val random = new Random(System.nanoTime())

    def getConnection(host: String, port: String): Connection =
      if (random.nextBoolean()) new Connection
      else throw new RuntimeException("Someone else took the port")

      def getSafeConnection(host: String, port: String): Try[Connection] = Try(getConnection(host, port))


    // If you get the html page from the connection, print it ot the console i.e. call renderHTML
    val possibleConnection = HttpService.getSafeConnection(hostname, port)
    val possibleHTML = possibleConnection.flatMap(connection => connection.getSafe("/home"))
    possibleHTML.foreach(renderHTML)
  }

  // Shorthand version
  HttpService.getSafeConnection(hostname, port)
    .flatMap(connection => connection.getSafe("/home"))
    .foreach(renderHTML)

  // for-comprehension
  for {
    connection <- HttpService.getSafeConnection(hostname, port)
    html <- connection.getSafe("/home")
  } renderHTML(html)

  /* Worst way as there could be many try expressions per block
    try {
    connection = HttpService.getConnection(hostname, port)
    try {
      connection.get("/home")
      renderHTML(page)
      } catch (some other exception) {

      }
    } catch (exception) {

    }
   */

}
