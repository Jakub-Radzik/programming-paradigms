import scala.compiletime.ops.int.+

object Main1 {
  val add = (x: Int, y: Int) => x + y

  def add2 = (x: Int, y: Int) => x + y

  def add3(x: Int, y: Int): Int = x + y

  def addThenMultiply(x: Int, y: Int)(mul: Int)(div: Int): Double = ((x + y) * mul) / div

  def name: String = System.getProperty("user.name")

  def getSquareString(input: Double): String = {
    val square = input * input
    square.toString
  }

  def main(args: Array[String]): Unit = {
    println(add(2, 2))
    println(add2(2, 2))
    println(addThenMultiply(2, 2)(10)(3))
    println(name)
    println(getSquareString(2.5))
  }


}
