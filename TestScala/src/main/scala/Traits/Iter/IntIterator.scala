package Traits.Iter

class IntIterator(to: Int) extends Iterator[Int] {
  private var current = 0

  override def hasNext: Boolean = current < to

  override def next(): Int = {
    if (hasNext) {
      val t = current
      current += 1
      t
    } else 0
  }
}
