def factorial(x: Int): Int = {
  def fact(x: Int, accumulator: Int = 1): Int = {
    if (x <= 1) accumulator
    else fact(x - 1, x * accumulator)
  }

  fact(x, 1)
}

for (y <- 'a' to 'z' by 2) println(y)

val a = List.range(0, 10)
val b = (1 to 10 by 2).toList
val c = ('a' to 'f').toList