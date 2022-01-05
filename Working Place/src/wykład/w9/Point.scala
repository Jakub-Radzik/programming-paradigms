package wykład.w9

import java.awt.Color

class Point(val x: Double, val y: Double) {
  def distance(other: Point): Double = {
    Math.sqrt(Math.pow(other.x - x, 2) + Math.pow(other.y - y, 2))
  }
}

class Pixel(xp: Double, yp: Double, protected var color: Color = Color.BLACK) extends Point(xp, yp) {
  println( s"pixel constructor: $this" )
  override def toString: String = {
    s"Pixel($x, $y, $color)"
  }
}

