val t1 = ("Sugar", 25)
t1._1
t1._2

val (quant, name) = t1

val planets = List(("Mercury", 57.9), ("Venus", 108.2), ("Earth", 149.6),
  ("Mars", 227.9), ("Jupiter", 778.3))

planets.foreach({
  case ("Earth", distance) => {
    println(s"Our planet is $distance from sun")
  }
  case _: scala.Tuple2[_, _] => println("not out business")
})

val numPairs = List((2, 5), (2, 3), (9, 9), (10, 10))
for ((a, b) <- numPairs) {
  println(a + b)
}