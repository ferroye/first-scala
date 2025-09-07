object FunctionPrograming extends App {
  //Scala is OO

  class Person(name: String) {
  }

  /*
  Scala runs on the JVM
  Functional programming:
  - compose functions
  - pass functions as args
  -  return functions are results
  Conclusion: FUnctionX = Function1,2......FUnction22 (parameter)

   */
  //defined a function
  val simpleIncrementer = new Function[Int, Int] {
    override def apply(arg: Int): Int = arg + 1
  }
  // All Scala functions are instances of these Function_x types

  val stringConcatenator = new Function2[String, String, String] {
    override def apply(v1: String, v2: String): String = v1 + v2
  }
  stringConcatenator("a", "b")
  //syntax sugars
  val doubler: Int => Int = (x: Int) => 2 * x
  val doubler2 = (x: Int) => 2 * x
  /*
  equivalent to the much longer:
  val doubler: function .... then apply what not
   */
  doubler(4)

  // higher-order functions: take functions as args/return functions as results
  val aMapList = List(1, 3).map(x => x + 1)
  println(aMapList)
  // flatmap It maps each element to a collection/monad and then flattens the result into a single collection/monad.
  val aFlatMapped = List(1, 2, 3).flatMap(x => List("a1"))
  println(aFlatMapped)
  // filter
  val aFilteredList = List(1, 2, 3).filter(x => x < 3)
  val aFilteredList2 = List(1, 2, 3).filter(_ < 3) // same as above
  println(1 to 20)

  // all pairs between the numbers 1,2,3 and the letters 'a', 'b'
  val allParis = List(1, 2, 3).flatMap(num => List('a', 'b').map(letter => s"$num-$letter"))
  println(allParis)

  //for comprehensions
  val alternativePairs = for {
    num <- List(1, 23)
    letter <- List("1", "23")
  } yield s"$num - $letter"

//  guide condition
//  refined the matching process -> a case with a guard will only execute its associated code block if the data
//  succesfflly matches the pattern and bollean condition is true

  /**
   * Collections
   */

  // Lists
  val aList = List(1, 2, 3, 4)
  //sequence
  val aseq: Seq[Int] = Seq(1, 2, 3)
  val accesElement = aseq(1)

  //vector: fast seq implementation
  val aVector = Vector(1, 2, 4)

  // set = no dup
  val aset = Set(1, 2, 3, 1)
  val setHas5 = aset.contains(5)
  val anAddSet = aset + 5 //set(1,2,3,5)
  val aRemoveSet = aset - 3 //set(1,2)

  // ranges
  val rang = 1 to 100
  val twoBy2 = rang.map(x => 2 * x).toList

  //tuples
  val aTuple = ("A", 123)

  //maps
  val phoneBook: Map[String, Int] = Map(
    "a" -> 1,
    "a1" -> 2,
  )
  println(phoneBook)
}
