//Jakub Radzik
//1

//2
//bez lukru
def curry3[a, b, c, d](f: (a, b, c) => d): a => b => c => d = x => y => z => f(x, y, z)
//z lukrem
def plusC(a: Int, b: Int, c: Int): Int = a + b + c

curry3(plusC)(3)(4)(5)

//bez lukru
def uncurry3[a, b, c, d](f: a => b => c => d) = (x: a, y: b, z: c) => f(x)(y)(z)
//z lukrem
def plusU(x: Int)(y: Int)(z: Int) = x + y + z

uncurry3(plusU)(3, 4, 5)

//3
def sumProd(xs: List[Int]): (Int, Int) = {
  (xs foldLeft(0, 1)) ((accumulator, h) => (accumulator._1 + h, accumulator._2 * h))
}

sumProd(List(1, 2, 3, 4, 5)) == (15, 120)
sumProd(List(1, 2, 3, 4, 5, 6, 7, 8)) == (36, 40320)
sumProd(List(2, 2, 2, 2, 2, 2)) == (12, 64)
sumProd(List(5, 5, 5, 5, 5)) == (25, 3125)

//4

//5
//a
val comparator = (a: Int, b: Int) => a > b

def insertionsort[A](comparator: (A, A) => Boolean, list: List[A]): List[A] = {
  def insertionSortHelper[A](comparator: (A, A) => Boolean, list: List[A], resultList: List[A]): List[A] = {
    (list, resultList) match {
      case (Nil, _) => resultList
      case (list, Nil) => insertionSortHelper(comparator, list.tail, list.head :: Nil)
      case (listUnordered, listOrdered) => {
        def checker(element: A, resultList: List[A]): List[A] = {
          if resultList == Nil then element :: Nil
          else if comparator(element, resultList.head) then resultList.head :: checker(element, resultList.tail)
          else element :: resultList
        }

        insertionSortHelper(comparator, list.tail, checker(listUnordered.head, listOrdered))
      }
    }
  }

  insertionSortHelper(comparator, list, List())
}

insertionsort(comparator, List(9, 1, 8, 4, 2)) == List(1, 2, 4, 8, 9)
insertionsort(comparator, List(10, 9, 8)) == List(8, 9, 10)
insertionsort(comparator, List(11, 9, 11)) == List(9, 11, 11)
insertionsort(comparator, List(10, 1, 2, 3, 4, 5)) == List(1, 2, 3, 4, 5, 10)

//TODO: testowanie stabilności

//b
def mergesort[A](comparator: (A, A) => Boolean, list: List[A]): List[A] = {
  val partition = list.length / 2
  if partition == 0 then list
  else {
    def merge(list1: List[A], list2: List[A]): List[A] = (list1, list2) match {
      case (Nil, list2) => list2
      case (list1, Nil) => list1
      case (head1 :: tail1, head2 :: tail2) =>
        if comparator(head2, head1) then head1 :: merge(tail1, list2)
        else head2 :: merge(list1, tail2)
    }

    val (left, right) = list.splitAt(partition)
    merge(mergesort(comparator, left), mergesort(comparator, right))
  }
}

mergesort(comparator, List(9, 1, 8, 4, 2)) == List(1, 2, 4, 8, 9)
mergesort(comparator, List(10, 9, 8)) == List(8, 9, 10)
mergesort(comparator, List(11, 9, 11)) == List(9, 11, 11)
mergesort(comparator, List(10, 1, 2, 3, 4, 5)) == List(1, 2, 3, 4, 5, 10)
