import java.util.{Date, Locale}
import java.text.DateFormat._

object HelloWorld {

  def main(args: Array[String]): Unit = {
    val now = new Date
    val df = getDateInstance(LONG, Locale.FRANCE)
    println(df format now)
    println(2 + 3)
    println("2" + 2 + 3 + 4)
    val x: Int = 1 + 19
    println(x)
    var y = 2
    y = 3
    y = 7
    println(y)
    {
      var y = 2
      println(y)
    }
    println(y)
  }
}