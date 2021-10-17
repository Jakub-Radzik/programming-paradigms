import scala.annotation.tailrec

//2a:
def fib(x: Int): Int = {
  x match {
    case 0 => 0
    case 1 => 1
    case _ => fib(x - 1) + fib(x - 2)
  }
}

//test 2a:
fib(5) == 5
fib(8) == 21
fib(11) == 89


//2b
def fibTail(x: Int): Int = {
  @tailrec
  def fibTailRec(n: Int, f1: Int, f2: Int): Int = {
    if (n == 0) 0
    else if (n == 1) f2
    else fibTailRec(n - 1, f2, f1 + f2)
  }

  fibTailRec(x, 0, 1)
}

//test 2b:
fibTail(0)
fibTail(1)
fibTail(2)
fibTail(3)
fibTail(4)
fibTail(5)

//rekurencja ogonowa jest o wiele szybsza od zwykłej
fib(42)
fibTail(42)

//3 method
def root3(a: Double): Double = {
  def root3Rec(x: Double): Double = {
    if (math.abs(math.pow(x, 3) - a) <= math.pow(10, -15) * math.abs(a)) x
    else root3Rec(x + (a / math.pow(x, 2) - x) / 3)
  }

  root3Rec(if (a > 1) a / 3 else a)
}

//3 function
val root3func: Double => Double = (a: Double) => {
  lazy val root3funcRec: Double => Double = (x: Double) =>
    if (math.abs(math.pow(x, 3) - a) <= math.pow(10, -15) * math.abs(a)) x
    else root3funcRec(x + (a / math.pow(x, 2) - x) / 3)
  root3funcRec(a)
};


//3 tests

root3(27.0) == 3.0
root3(216.0) == 6.0
root3(1000.0) == 10.0
root3func(27.0) == 3.0
root3func(216.0) == 6.0
root3func(1000.0) == 10.0

//4
val patternA = List(-2, -1, 0, 1, 2)
val patternB = List((1, 2), (0, 1))

val List(_, _, x, _, _) = patternA;
val List(_, (y, _)) = patternB;
x == 0
y == 0

//5
def initSegment[A](xs: List[A], ys: List[A]): Boolean = {
  if (xs.length > ys.length) false
  else {
    (xs, ys) match {
      case (Nil, _) => true
      case (_, Nil) => false
      case _ => if (xs.head == ys.head) initSegment(xs.tail, ys.tail) else false
    }
  }
}
//5 tests
initSegment(List(1, 2, 3), List(1, 2, 3))
initSegment(List(), List())
initSegment(List(), List(1))
initSegment(List(2), List(1)) == false
initSegment(List("a", "b"), List("a", "b", "c"))
initSegment(List("a", "b", "c"), List("a", "b")) == false

//6a

def replaceNth[A](xs: List[A], n: Int, x: A): List[A] = {
  (xs, n) match {
    case (Nil, _) => Nil
    case (_::tail, 0) => x :: tail
    case (head::tail, _) => head :: replaceNth(tail, n - 1, x)
  }
}

replaceNth(List(1, 2, 3, 4, 5), 0, 10) == List(10, 2, 3, 4, 5)
replaceNth(List(1, 2, 3, 4, 5), 1, 10) == List(1, 10, 3, 4, 5)
replaceNth(List(1, 2, 3, 4, 5), 3, 10) == List(1, 2, 3, 10, 5)
replaceNth(List(1, 2, 3, 4, 5), 11, 10) == List(1, 2, 3, 4, 5)

val list1 = List('o', 'l', 'a', 'm', 'a', 'k', 'o', 't', 'a')
val list2 = List('o', 's', 'a', 'm', 'a', 'k', 'o', 't', 'a')

replaceNth(list1, 1, 's') == list2
