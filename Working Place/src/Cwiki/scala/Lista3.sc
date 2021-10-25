//Jakub Radzik
//1

//2
//rozwijanie
//bez lukru
def curry3[a, b, c, d](f: (a, b, c) => d): a => b => c => d = x => y => z => f(x, y, z)
//z lukrem
def plusC(a: Int, b: Int, c: Int): Int = a + b + c

curry3(plusC)(3)(4)(5)

//zwijanie
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
def insertionsort[A](f: (A, A) => Boolean, xs:List[A]): List[A] = {
  def insert(xs: List[A], x: A): List[A] = {
    xs match {
      case Nil => List(x)
      case h :: t if f(x,h) => h :: insert(t, x)
      case h :: t => x :: h :: t
    }
  }
  xs.foldLeft(List.empty[A])(insert)
}

insertionsort((a: Int, b: Int) => a > b, List(9, 1, 8, 4, 2)) == List(1, 2, 4, 8, 9)
insertionsort((a: Int, b: Int) => a > b, List(10, 9, 8)) == List(8, 9, 10)
insertionsort((a: Int, b: Int) => a > b, List(11, 9, 11)) == List(9, 11, 11)
insertionsort((a: Int, b: Int) => a > b, List(10, 1, 2, 3, 4, 5)) == List(1, 2, 3, 4, 5, 10)
//TEST STABILNOSCI
insertionsort((p1:(Int, Int), p2:(Int, Int)) => p1._1 >= p2._1, List((1,2),(1,3),(2,3),(2,4),(200,2),(100,1),(120,3))) == List((1,2), (1,3), (2,3), (2,4), (100,1), (120,3), (200,2))
insertionsort((p1:(Int, Int), p2:(Int, Int)) => p1._1 >= p2._1, List((1,3),(1,2),(2,3),(2,4),(200,2),(100,1),(120,3))) == List((1,3), (1,2), (2,3), (2,4), (100,1), (120,3), (200,2))
insertionsort((x: (Int, Char), y: (Int, Char)) => x._1 >= y._1, List((5, 'a'), (3, 'a'), (5, 'b'), (6, 'a'), (2, 'a'), (9, 'a'), (6, 'b'), (2, 'b'), (6, 'c'))) == List((2,'a'), (2,'b'), (3,'a'), (5,'a'), (5,'b'), (6,'a'), (6,'b'), (6,'c'), (9,'a'))
