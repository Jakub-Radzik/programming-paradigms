def pascalTriangle(c: Int, r: Int): Int = {
  @tailrec
  def loop(c0: Int, r0: Int, pred: Array[Int], cur: Array[Int]): Int = {
    cur(c0) = (if (c0 > 0) pred(c0 - 1) else 0) + (if (c0 < r0) pred(c0) else 0)

    if ((c0 == c) && (r0 == r)) cur(c0)
    else if (c0 < r0) loop(c0 + 1, r0, pred, cur)
    else loop(0, r0 + 1, cur, new Array(_length = r0 + 2))
  }

  if ((c == 0) && (r == 0)) 1
  else loop(0, 1, Array(1), Array(0, 0))
}

pascalTriangle(0, 0)