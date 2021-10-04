package Traits

class CustomizableGreeter() extends Greeter {
  override def greet(name: String): Unit = println("Siema " + name)
}
