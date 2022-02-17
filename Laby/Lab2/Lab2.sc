import scala.annotation.tailrec

// 1:
def find[A](y: List[A])(x: A): Boolean = {
  y match {
    case (h :: t) if h == x => true
    case (h :: t) => find(t)(x)
    case _ => false
  }
}
//1 tests
val find123 = find(List(1, 2, 3))
find123(1) == true
find123(13) == false
find123(5) == false

val findInChars = find(List('a', 'b', 'c'))
findInChars('a') == true
findInChars('x') == false
findInChars(1) == false

def split2Tail[A](list: List[A]): (List[A], List[A]) = {
  @tailrec
  def split2Tail[A](list: List[A], pair: (List[A], List[A])): (List[A], List[A])  = {
    list match {
      case h::t => split2Tail(t, (h::pair._2, pair._1))
      case a => (a:::pair._1, pair._2)
    }
  }
  split2Tail(list, (List(), List()))
}

split2Tail(List(1,2,3)) == (List(3, 1),List(2))
split2Tail(List(1,2,3,4)) == (List(4, 2),List(3, 1))
split2Tail(List(1,2,3,4,5,6,7,8,9,10)) == (List(10, 8, 6, 4, 2),List(9, 7, 5, 3, 1))
split2Tail(List()) == (List(),List())

def split2Rec[A](list: List[A]): (List[A], List[A]) = {
  def split2RecHelper(list: List[A]): (List[A], List[A]) = list match {
    case Nil => (Nil, Nil)
    case h :: Nil => (List(h), Nil)
    case f1 :: f2 :: tail =>
      val (a, b) = split2RecHelper(tail)
      (f1::a, f2::b)
  }
  split2RecHelper(list)
}

split2Rec(List(1,2,3)) == (List(1, 3),List(2))
split2Rec(List(1,2,3,4)) == (List(1, 3),List(2, 4))
split2Rec(List(1,2,3,4,5,6,7,8,9,10)) == (List(1, 3, 5, 7, 9),List(2, 4, 6, 8, 10))
split2Rec(List()) == (List(),List())