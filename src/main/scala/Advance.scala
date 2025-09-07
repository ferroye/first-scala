import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success, Try}

object Advance extends App {
  // lazy evaluation
  // only used when used

  lazy val aLazyVal = 2 // this will not assigned before used
  lazy val lazyWithSideEffect = {
    println("im so very lazy!")
    43
  }
  // will print stuff on console  which is being evaled on runtime
  val notLazyWithSideEffect = {
    println("im not lazy!")
    43
  }

  val eagerVal = lazyWithSideEffect + 1

  //pseudo-collections: Option, Try
  def someMethod(): String = {
    println("some method")
    "abc"
  }
  val op = Option(someMethod())
  // pattern matching
  val c = op match {
    case Some(a) => " $a"
    case None => "Empty"
  }
  println(c)

  def methodException():String = throw new RuntimeException("some....")
  val aTry = Try(methodException())
  // a try = collection with either a value if the code went well or an exception if the code threw one
  val someProcess = aTry match {
    case Success(value) => s" $value"
    case Failure(exception) => s" $exception"
  }

  /**
   * Evaluate something on another thread
   * async programming
   */
  val f = Future({
    println("loading")
    Thread.sleep(1000)
    println("I have computed a value")
    123
  })
  // future is a collection which contains a value when its evaulted 
  // future is composable with map, flatmap and filter 

  /**
   * Implicitis basic 
   */
  // 1. implicit arguments 
  




}
