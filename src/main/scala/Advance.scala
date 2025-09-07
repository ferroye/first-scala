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
  var afuture = Future {
    print("loading..l")
    Thread.sleep(1000)
    println("completed a task")
    67
  }
  // future is a collection which contains a value when its evaulted 
  // future is composable with map, flatmap and filter
  // monads -> some sort of collection

//

  /**
   * Implicitis basic 
   */
  // 1. implicit arguments
  def aMethodWithImplicitArgs(implicit arg: Int) = arg +1

  implicit val abc: Int = 46
  println(aMethodWithImplicitArgs) //aMethodWithImplicitArgs(myImplicitInt)

  // 2.implicit conversions
  implicit class MyRichInteger(n:Int) {
    def isEven() = n%2 ==0
  }
  println(23.isEven()) // new MyRichInteger(23).isEven()
  // use this careful.
  // as part of the upgrade scala3, the extension intead




}
