//Jakub Radzik

//3
def sumProd(xs: List[Int]): (Int, Int) = {
  xs.foldLeft(0, 1)((accumulator, h) => (accumulator._1 + h, accumulator._2 * h))
}

sumProd(List(1, 2, 3, 4, 5)) == (15, 120)
sumProd(List(1, 2, 3, 4, 5, 6, 7, 8)) == (36, 40320)
sumProd(List(2, 2, 2, 2, 2, 2)) == (12, 64)
sumProd(List(5, 5, 5, 5, 5)) == (25, 3125)
