//Jakub Radzik
// 1
def lrepeat[A](k: Int)(lxs: LazyList[A]): LazyList[A] = {
  if (k < 1) throw new Exception("liczba powtorzen mniejsza niz 1")

  def lrepeatHelper(repeats: Int, rest: LazyList[A]): LazyList[A] =
    (repeats, rest) match {
      case (_, LazyList()) => LazyList()
      case (0, hd #:: tl) => lrepeatHelper(k, tl)
      case (_, hd #:: tl) => hd #:: lrepeatHelper(repeats - 1, rest)
    }

  lrepeatHelper(k, lxs)
}

lrepeat(3)(LazyList('a', 'b', 'c', 'd')).toList == List('a', 'a', 'a', 'b', 'b', 'b', 'c', 'c', 'c', 'd', 'd', 'd')
lrepeat(3)(LazyList.from(1)).take(15).toList == List(1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5)
lrepeat(3)(LazyList()).take(15).toList == List()

// 2
def lfib(): LazyList[Int] = {
  def fib(a: Int, b: Int): LazyList[Int] = a #:: fib(b, a + b)

  fib(1, 1)
}

lfib().take(15).toList == List(1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610)
lfib().take(3).toList == List(1, 1, 2)
lfib().take(1).toList == List(1)
lfib().take(0).toList == List()


// 3
sealed trait lBT[+A]

case object LEmpty extends lBT[Nothing]

case class LNode[+A](elem: A, left: () => lBT[A], right: () => lBT[A]) extends lBT[A]

// 3 a
def lBreadth[A](ltree: lBT[A]): LazyList[A] = {
  def lBreadthHelper(list: List[lBT[A]]): LazyList[A] =
    list match {
      case Nil => LazyList()
      case LEmpty :: tl => lBreadthHelper(tl)
      case LNode(v, l, r) :: tl => v #:: lBreadthHelper(tl ++ List(l(), r()))
    }

  lBreadthHelper(List(ltree))
}

// 3 b
def lTree(n: Int): lBT[Int] =
  LNode(
    n,
    () => lTree(2 * n),
    () => lTree(2 * n + 1)
  )

lBreadth(lTree(1)).take(20).toList == List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20)
lBreadth(LEmpty).take(20).toList == List()
lBreadth(lTree(3)).take(10).toList == List(3, 6, 7, 12, 13, 14, 15, 24, 25, 26)

