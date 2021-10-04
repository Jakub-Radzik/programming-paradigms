package Traits

object Runner {
  def main(args: Array[String]): Unit = {
    val greeter = new CustomizableGreeter()
    greeter.greet("scala")
  }
}
