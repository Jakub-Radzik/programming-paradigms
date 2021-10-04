case class Point(x: Int, y: Int)

val point1 = Point(1, 2)
val point2 = Point(1, 2)
val point3 = Point(2, 1)
println(point1 == point2)
println(point2 == point3)