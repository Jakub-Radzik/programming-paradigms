package Traits

trait Greeter {
  def greet(name: String): Unit

  def greet2(name: String): Unit =
    println("Hello, " + name)
}
