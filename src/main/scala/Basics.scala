import scala.util.chaining

object Basics extends App {
  // defining a value
  val meaningOfLifeDef: Int = 42 // const int meaningOfLife =42;
  val meaningOfLife = 42
  val b: Boolean = false
  println(f" $meaningOfLifeDef $meaningOfLife") // interpolate - insert

  //expressions = structures that can be reduced to a value
  val anExpression = 2 + 3 // + is actully a method instead of a operation
  // if - expression  all expression will assign to a value at the end
  val ifExpression = if (meaningOfLife > 43) 56 else 999 // meaningOfLife>43 ?

  val chainedIf =
    if (meaningOfLife > 43){
      56
    }
    else{
      560
    }

  println(chainedIf)
  //code blocks
  val aCodeBlock = {
    val anExpression = 1
    // last line is the return statement
    anExpression + 1
  }
  println(aCodeBlock)


  // define a function
  def foo(x:Int, y : String ) : String = {
    y+ " " + x
  }
  // recursive functions
  def factorial(n: Int) : Int =
    if (n<=1) 1
    else n* factorial(n-1)

  // In Scala we dont use loops or iteration, we use RECURISION!
  // the Unit type = no meaningful value === "void" in other language
  // type of SIDE EFFECTS -> not computing any meaningful info, print -> other processes return void

  def myUnit() : Unit = {
    print(" my unit func")
  }

  println(myUnit())
  val ar = Array(1,2,3,4)
  println(ar)

  ar(1) = 12
  println(ar)

  // Array -> has size
  // List -> linkedList no size
  // Vector -> indexed by hashing good performance across all operations A linkedList of 32 elements arrays if more then create another one and point to it
  // Set (no order)

}
