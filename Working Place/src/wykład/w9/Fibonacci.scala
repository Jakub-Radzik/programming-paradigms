package wykład.w9

object Fibonacci:
  private var F = Map[Int, Int](0 -> 0, 1 -> 1)

class Fibonacci {
  import Fibonacci.F
  def num(n: Int): Int =
    if !F.contains(n) then
      var k = 2
      while k <= n do
        F += (k -> (F(k - 1) + F(k - 2)))
        k += 1
    end if
    F(n)
}
