def revNComp(f: Int => Int)(n: Int)(x: Int): List[Int] = {
  def revNCompInside(f: Int => Int, n: Int, x: Int, list: List[Int]): List[Int] = {
    if n <= 0 then Nil
    else if n == 1 then x :: list
    else revNCompInside(f, n - 1, f(x), x :: list)
  }

  revNCompInside(f, n, x, List())
}
revNComp(((x: Int) => x * x))(5)(2) == List(65536, 256, 16, 4, 2)
revNComp(((x: Int) => x + 2))(5)(2) == List(10, 8, 6, 4, 2)
revNComp(((x: Int) => x + 10))(5)(2) == List(42, 32, 22, 12, 2)

//2

def area(a: Double, b: Double)(f: Double => Double)(n: Int) = {
  def createList(count: Int): List[Int] = {
    if count < n then count :: createList(count + 1)
    else List()
  }
  val (xs, diff) = (createList(1), ((b - a) / (n-1)))
  xs.map(x=>f(a + diff * x)*diff).foldLeft(0.0)((acc, x) => acc+x)
}

area(1.0, 4.0)(x => x * x)(2)
area(0.0, 1.0)(x => x * x * x)(1000)
