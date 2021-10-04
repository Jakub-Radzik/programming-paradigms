class Greeter(prefix: String, suffix: String) {
  def greet(name: String): Unit = {
    println(prefix+name+suffix)
  }
}
