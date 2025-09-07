object ContextualAbstractions {
  val aList = List(2, 1, 3, 4)
  val orderList = aList.sorted // contextual argument : (desc)

  //ordering // does not need to apply anywhere, this is injected by default
  given desc: Ordering[Int] = Ordering.fromLessThan(_ > _) // (a,b ) = > a>b

  // simular to an implicit val
  trait Combinator[A] {
    def combine(x: A, y: A): A
  }

  def combineAll[A](list: List[A])(using combinator: Combinator[A]): A =
    list.reduce((a, b) => combinator.combine(a, b))

  given intCombinator: Combinator[Int] = new Combinator[Int] {
    override def combine(x: Int, y: Int): Int = x + y
  }

  def combineAll_v2[A](list: List[A])(using Combinator[A]): A = ??? // same asbelow

  def combineAll_v3[A: Combinator](list: List[A]): A = ???
  // same as above saying that this combine needs a combinator
  // otherwise it will compile

  /*

  where context args are useful
  1. type classes
  2. DI
  3. context0dependent functionality
  4. type - level programing
   */

  /*
  2. - extension methods
   */
  case class Person(name: String) {
    def greet(): String = s"Hi $name"
  }
  extension (string: String)
    def greet(): String = new Person(string).greet()

  val danielsGteeting = "Daniel".greet() // type enrichment

  val theSum = combineAll(aList)

//  POWER
  extension [A](list:List[A])
    def combineAllValues(using combinator:Combinator[A]) : A =
      list.reduce(combinator.combine)
val theSumV2 = aList.combineAllValues
  /*
  given places
    - local scope
    - imported scope
    - the compaions of all the types involved in the call
       - companion of List
       - the companion of Int
   */

  def main(args: Array[String]): Unit = {
    /*
      1. context parameters/arguments
       */

    println(theSumV2)
  }

}
