//JAKUB RADZIK

sealed trait BT[+A]
case object Empty extends BT[Nothing]
case class Node[+A](elem: A, left: BT[A], right: BT[A]) extends BT[A]

// Test trees
val tt = Node(1,
  Node(2,
    Node(4, Empty, Empty),
    Empty),
  Node(3,
    Node(5, Empty,
      Node(6, Empty, Empty)),
    Empty))

val myTree = Node(1,
  Node(2,
    Node(4,
      Node(9, Empty, Empty),
      Node(10, Empty, Empty)
    )
    , Empty
  ),
  Node(10,
    Node(11, Empty, Empty),
    Node(12, Empty, Empty)
  )
)

//3
def breadthBT[A](tree: BT[A]): List[A] = {
  def breadth(list: List[BT[A]]): List[A] = list match {
    case Nil => Nil
    case Empty :: taill => breadth(taill)
    case Node(value, left, right) :: tail => value :: breadth(tail ::: (left :: right :: Nil))
  }
  breadth(List(tree))
}

breadthBT(tt) == List(1, 2, 3, 4, 5, 6)
breadthBT(Empty) == List()
breadthBT(myTree) == List(1, 2, 10, 4, 11, 12, 9, 10)

// 4 a
def internalBT[A](tree: BT[A]): Int = {
  def inter(t: BT[A], acc: Int): Int = t match {
    case Empty => throw new IllegalArgumentException()
    case Node(value, Empty, Empty) => acc
    case Node(value, left, Empty) => acc + inter(left, acc + 1)
    case Node(value, Empty, right) => acc + inter(right, acc + 1)
    case Node(value, left, right) => acc + inter(left, acc + 1) + inter(right, acc + 1)
  }

  inter(tree, 0)
}
//internalBT(Empty) - wyjątek
internalBT(tt) == 9
internalBT(myTree) == 14

// 4 b
def externalBT[A](tree: BT[A]): Int = {
  def exter(t: BT[A], acc: Int): Int = t match {
    case Empty => acc
    case Node(value, Empty, Empty) => 2 * (acc + 1)
    case Node(value, left, Empty) => acc + 1 + exter(left, acc + 1)
    case Node(value, Empty, right) => acc + 1 + exter(right, acc + 1)
    case Node(value, left, right) => exter(left, acc + 1) + exter(right, acc + 1)
  }

  exter(tree, 0)
}

externalBT(tt) == 21
externalBT(myTree) == 30

// 5

sealed trait Graphs[A]
case class Graph[A](succ: A => List[A]) extends Graphs[A]

val graph = Graph((i: Int) => i match {
  case 0 => List(3)
  case 1 => List(0, 2, 4)
  case 2 => List(1)
  case 3 => Nil
  case 4 => List(0, 2)
  case n => throw new Exception("Graf g: NODE: " + n + " nie istnieje")
})

def depthSearch[A](graph: Graph[A])(startNode: A): List[A] = {
  def search(visited: List[A])(toVisit: List[A]): List[A] = toVisit match {
    case Nil => Nil
    case head :: tail =>
      if (visited contains head) search(visited)(tail)
      else head :: search(head :: visited)((graph succ head) ::: tail)
  }

  search(Nil)(List(startNode))
}

depthSearch(graph)(4) == List(4, 0, 3, 2, 1)
depthSearch(graph)(2) == List(2, 1, 0, 3, 4)
depthSearch(graph)(1) == List(1, 0, 3, 2, 4)