def revNComp(f: Int => Int)(n: Int)(x: Int): List[Int] = {
  def revNCompInside(f: Int => Int, n: Int, x: Int, list: List[Int]): List[Int] = {
    if n <= 0 then Nil
    else if n == 1 then List(x)
    else revNCompInside(f, n - 1, f(x), x :: list)
  }

  revNCompInside(f, n, x, List())
}
revNComp(((x: Int) => x * x))(5)(2)
revNComp(((x: Int) => x + 2))(5)(2) == List(10, 8, 6, 4, 2)
revNComp(((x: Int) => x + 10))(5)(2) == List(42, 32, 22, 12, 2)

//2





