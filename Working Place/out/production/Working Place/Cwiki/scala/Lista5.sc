//Jakub Radzik
// 1
def ltake [A](k: Int, llist: LazyList[A]):List[A] =
  (k, llist) match {
    case (0, _) => Nil
    case (_, LazyList()) => Nil
    case (n, hd#::tl) => hd::ltake(n-1, tl)
  }

def lfrom (k:Int):LazyList[Int] = k#::lfrom(k+1)

def lrepeat[A](k: Int)(lxs: LazyList[A]):LazyList[A]= {
  if (k < 1) throw new Exception ("liczba powtorzen mniejsza niz 1")
  def lrepeatHelper(rpts: Int, rest: LazyList[A]): LazyList[A] =
    (rpts, rest) match {
      case (_, LazyList()) => LazyList()
      case (0, hd #:: tl) => lrepeatHelper(k, tl)
      case (_, hd #:: tl) => hd#::lrepeatHelper(rpts - 1, rest)
    }
  lrepeatHelper(k, lxs)
}

lrepeat(3)(LazyList('a','b','c','d')).toList == List('a', 'a', 'a', 'b', 'b', 'b', 'c', 'c', 'c', 'd', 'd', 'd')
lrepeat(3)(LazyList.from(1)).take(15).toList == List(1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5)
lrepeat(3)(LazyList()).take(15).toList == List()

// 2

def lfib():LazyList[Int] = {
  def fib(a:Int,b:Int):LazyList[Int] = a #:: fib(b,a+b)
  fib(1,1)
}

lfib().take(15).toList

// 3

sealed trait lBT[+A]
case object LEmpty extends lBT[Nothing]
case class LNode[+A](elem:A, left:()=>lBT[A], right:()=>lBT[A]) extends lBT[A]

// 3 a
def generateTree(n: Int):lBT[Int] =
  LNode(n, ()=>generateTree(2*n), ()=>generateTree(2*n+1))

def lBreadth[A](ltree: lBT[A]): LazyList[A] = {
  def lBreadthHelper(list: List[lBT[A]]):LazyList[A] =
    list match{
      case Nil => LazyList()
      case LEmpty::tl => lBreadthHelper(tl)
      case LNode(v, l, r)::tl => v #:: lBreadthHelper(tl ++ List(l(), r()))
    }
  lBreadthHelper(List(ltree))
}

// 3 b
def lTree(n:Int):lBT[Int] = LNode(n,()=>lTree(2*n),()=>lTree(2*n+1))

def lTreeToList[A](tree:lBT[A]):LazyList[A] = {
  def toLlist(list: List[lBT[A]]):LazyList[A] = list match {
    case Nil => LazyList.empty
    case LEmpty :: tl => toLlist(tl)
    case LNode(v,l,r) :: tl => v #:: toLlist(tl ++ (l()::r()::Nil))
  }
  toLlist(List(tree))
}

//3 tests
lBreadth(lTree(1)).take(20).toList == List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20)
lBreadth(LEmpty).take(20).toList == List()
