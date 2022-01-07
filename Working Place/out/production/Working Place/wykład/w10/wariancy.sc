sealed trait Animal
class Dog extends Animal
class Cat extends Animal
class Lion extends Cat
class Simba extends Lion
//
//class AnimalWrapper[+T](animal: T)
//
////val a = new AnimalWrapper[Animal](new Dog)
////val b = new AnimalWrapper[Dog](new Dog)
////val c = new AnimalWrapper[Cat](new Simba)
//
//val d: AnimalWrapper[Animal] = new AnimalWrapper[Cat](new Simba)



abstract class Sequence1[A] {
  def append[A](x: Sequence[A]): Sequence[A]
}

abstract class Sequence[+A] {
  def append[B>:A](x: Sequence[B]): Sequence[B]
}


