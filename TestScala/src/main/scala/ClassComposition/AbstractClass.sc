abstract class AbsIterator {
  type T

  def hasNext: Boolean

  def next: T
}

class StringIterator(s: String) extends AbsIterator {
  type T = Char
  private var i = 0

  override def hasNext: Boolean = i < s.length

  override def next = {
    val ch = s charAt i
    i += 1
    ch
  }
}

trait RichIterator extends AbsIterator {
  def foreach(f: T => Unit): Unit = while (hasNext) f(next)
}

class RichStringIter extends StringIterator("Hello Scala") with RichIterator

val r1 = new RichStringIter
r1.foreach((elem) => println(elem))
