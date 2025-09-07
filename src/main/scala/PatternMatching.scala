object PatternMatching extends App {
  // switch expression
  val anInt = 55
  val order = anInt match {
    case 1 => "first"
    case _ => anInt + "a"
  }
  // PM is an expression
  println(order)

  // case class decomposition
  //case class
  case class Person(name: String, age: Int)

  val bob = Person("Bob", 12) //Person.apply(xx,xx)

  val personGreeting = bob match {
    case Person(n, a) => s"Hi, my name is $n and i am $a yr old."
    case _ => "Something else "
  }
  print(personGreeting)

  // deconstructing tuples
  val tp = ("A","B")
  val tpDesc = tp match {
    case (a,b) => s" $a , $b"
    case _ => "uknokwn List"
  }
  // if PM does not match anything, it will throw a MatchError

  //decomposing lists
  val aList = List(1,2,3)
  val listDesc = aList match {
    case List(_,b,c) => s" $b $c"
    case _ => "something else"
  }

  println(listDesc)

  // pattern matching will go thought sequence
}
