object ObjetOrientation extends App {

  //class and instance
  class Animal {
    val age: Int = 0

    def eat(): Unit = println("im eating")
  }

  val anAnimal = new Animal

  // constructor definition
  // constructor arguments are NOT fields
  // class Dog(name:String) extends Animal -> notice that val is not in the name
  // the name argument is ephemeral, its not visiable outside of the Dog Class


  class Dog(val name: String) extends Animal // if we put a val then it means fields

  val aDog = new Dog("Lassie")
  print(aDog.name)

  // subtype polymorphism
  val aDeclaredAnimal: Animal = new Dog("Hachi")
  aDeclaredAnimal.eat() // the most derived method will be called at runtime

  //abstract class
  abstract class WalkingAnimal {
    val hasLegs = true // by default public, can resticted by quialifier

    def walk(): Unit
  }

  class human extends WalkingAnimal {
    override def walk(): Unit = ???
  }

  //  interface = ultimate abstract type
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  trait Philosopher {
    def ?!(thought: String): Unit // valid method name
  }

  //single class inheritance, multi-trait "mixing"
  class Crocodile extends Animal with Carnivore {

    override def eat(animal: Animal): Unit = println("im eating you ...")
  }

  val aCroc = new Crocodile
  aCroc.eat(aDog)
  aCroc eat aDog //infix notation = object method argument, only availabe for method with ONE argument
  // operator in scala are actually methods

  // anonymous classes
  val dinosaur = new Carnivore {
    /*
    class Carnivore_Anonyumous_35728 extends Carnivore{
    xyz }
    val dinosaur = new Carnivore_Anonyumous_35728
     */
    override def eat(animal: Animal): Unit = println("im a dianosaur")
  }

  // singleton object all this object keyword are singleton
  object MySingleton { // the only instance of the MySingle type
    val myspecialValue = 123

    def someMethod(): Int = 321

    def apply(x: Int): Int ={
      println(" inside Apply")
      x + 1
    }
  }

  MySingleton.someMethod()
  MySingleton.apply(12)
  MySingleton(12) // equivalent to MySingleton.apply(12)


  object Animal { // companions - companion object
    // companions can access each other's private fields/methods
    // singleton Animal and instances of Animal are different things
    val canLive4Ever: Boolean = false
  }

  val a = Animal.canLive4Ever // "static" fields/methods

  /*
   case class = lighweight data structure with some boilerplate
  - sensible equals and hash code
  - serialization
  - companion with apply
  - pattern matching
   */
  case class Person(name: String, age: Int)

  val bob = Person("Bob", 4)
  val bob2 = Person("Bob",1)
  // case class does not need case classes don’t require
  // new when you instantiate them because the compiler
  // automatically generates an apply method in the companion object
  // of the case class.

  // case object are singleton
  println(bob==bob2)

  //exceptions
  try {
    val x: String = null
    x.length
  } catch {
    case e: Exception => {
      print(e)
      "some falty error message"
    }
  } finally {
    //    dosomething
  }

  // generics
  abstract class MyList[T] {
    def head: T

    def tail: MyList[T]
  }

  val aList: List[Int] = List(1, 2)

  //Point #1 : in scala we useually operate with IMMUTABLE values/objects
  // Any mofication to an object must return another object
  /*
    Benefits:
    1.works miracles in multithreaded/distributed env speed up too.
    2. helps make sense of code
   */
   // Point #2: Scala is closest to the OO ideal


}