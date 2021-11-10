//type ParaX[Param] = (Int, Param)
//type ParaXFloat = ParaX[Float]
//val x: ParaXFloat = (2, 2.2f)

//kolor
sealed trait Kolor

case object Trefl extends Kolor

case object Pik extends Kolor

case object Karo extends Kolor

case object Kier extends Kolor

sealed trait Karta

case class Blotka(kolor: Kolor, wartosc: Int) extends Karta

case class As(kolor: Kolor) extends Karta


val przedzial: Int => Int => List[Int] = a => b =>
  if a > b then Nil
  else b :: (przedzial(a)(b - 1))

def map[A, B](f: A => B)(xs: List[A]): List[B] =
  xs match
    case Nil => Nil
    case x :: xs => f(x) :: map(f)(xs)

def wszystkieKarty(kol: Kolor): List[Karta] =
  val figury = List(As(kol))
  val blotki = map((n: Int) => Blotka(kol, n))(przedzial(2)(10))
  figury ::: blotki

wszystkieKarty(Kier)

sealed trait AB[+T1, +T2]

case class A[+T1, +T2](e: T1) extends AB[T1, T2]

case class B[+T1, +T2](e: T2) extends AB[T1, T2]

val lst: List[AB[String, Int]] = List(A("Ala"), B(1))
