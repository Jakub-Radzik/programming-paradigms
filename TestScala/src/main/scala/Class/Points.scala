package Class

object Points {

  def log(msg: String, level: String = "INFO"): Unit = println(s"$level: $msg")

  def main(args: Array[String]): Unit = {
    val p1 = new Point(1, 2)
    val p2 = new Point(2, 2)
    println(p1.toString + p2.toString)
    log("siema")
    log(msg="hejo", level = "WARN")
  }
}
