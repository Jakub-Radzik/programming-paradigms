abstract class A {
  val msg: String
}

class B extends A {
  val msg = "B from A"
}

trait C extends A {
  def loudMsg = msg.toUpperCase()
}

class D extends B with C

val d = new D
println(d.msg)
println(d.loudMsg)